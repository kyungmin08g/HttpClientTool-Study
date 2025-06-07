package kyungmin.httpclienttoolstudy.aspect;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.StopWatch;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class TimeAspect {

  @Around("execution(* kyungmin.httpclienttoolstudy.rest_client.controller.*.*(..))")
  public Object timeAspect(ProceedingJoinPoint joinPoint) throws Throwable {
    StopWatch stopWatch = new StopWatch(); // 스탑워치 준비

    stopWatch.start(); // 실행
    Object result = joinPoint.proceed(); // 메서드 실행
    stopWatch.stop(); // 멈춤

    String className = joinPoint.getTarget().getClass().getSimpleName(); // 클래스 이름 얻기
    String methodName = joinPoint.getSignature().getName(); // 메서드 이름 얻기

    log.info("{}.{}() 메서드 실행시간: {}", className, methodName, stopWatch.formatTime()); // 로그 출력
    return result;
  }
}
