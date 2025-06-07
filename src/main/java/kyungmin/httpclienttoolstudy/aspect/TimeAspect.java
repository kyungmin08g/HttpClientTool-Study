package kyungmin.httpclienttoolstudy.aspect;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.StopWatch;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class TimeAspect {

  @Before("@annotation(org.springframework.web.bind.annotation.GetMapping)")
  public void beforeLog() {
    log.info("GetMapping 메서드가 실행됨.");
  }

  @After("execution(* kyungmin.httpclienttoolstudy.rest_client.controller.*.*(..))")
  public void successLog() {
    log.info("성공적으로 실행되었습니다.");
  }

  @AfterThrowing(value = "execution(* kyungmin.httpclienttoolstudy.rest_client.controller.*.*(..))", throwing = "e")
  public void exceptionLog(JoinPoint joinPoint, RuntimeException e) {
    System.out.println("메서드 비정상 종료: " + joinPoint.getSignature().getName());
    e.printStackTrace();
  }

  /**
   * RestClientController의 메서드 실행 시간을 측정하는 메서드
   * --------------------------------------------------------------------------------------------
   * Around("execution(* kyungmin.httpclienttoolstudy.rest_client.controller.*.*(..))")
   * | @Around : 메서드 실행 전/후, 또는 예외 발생 시 모든 타이밍에 끼어들 수 있음 -> 메서드 실행을 직접 제어하면서, 전/후 처리를 내 마음대로 할 수 있는 도구라고 생각하면 쉬움
   * | execution() : 메서드 실행 시점을 기준으로 AOP를 적용하겠다는 의미
   * | '*' : 리턴 타입이 뭐든 상관없음 (void, String, int등 전부 포함)
   * | kyungmin.httpclienttoolstudy.rest_client.controller.* : 이 패키지 안에 있는 모든 클래스를 의미
   * | .*(..) : 각 클래스 안에 있는 모든 메서드를 의미이며 (..)는 매개변수가 몇 개든 상관없다는 의미 (0개든 100개든)
   * --------------------------------------------------------------------------------------------
   *
   * @param joinPoint : 실행하려는 메서드의 정보(제어)?를 담고 있는 친구
   * @return : 대상 메서드의 반환 타입과 동일해야하는데 큰 범위인 Object로 설정 -> 대상 메서드의 반환 타입
   */
  @Around("execution(* kyungmin.httpclienttoolstudy.rest_client.controller.*.*(..))")
  public Object timeAspect(ProceedingJoinPoint joinPoint) {
    StopWatch stopWatch = new StopWatch(); // 스탑워치 준비
    String className = joinPoint.getTarget().getClass().getSimpleName(); // 클래스 이름 얻기
    String methodName = joinPoint.getSignature().getName(); // 메서드 이름 얻기

    try {
      stopWatch.start(); // 실행
      Object result = joinPoint.proceed(); // 메서드 실행
      stopWatch.stop(); // 멈춤

      log.info("{}.{}() 메서드 실행시간: {}", className, methodName, stopWatch.formatTime()); // 로그 출력
      return result;
    } catch (Throwable e) {
      throw new RuntimeException(e);
    }
  }
}
