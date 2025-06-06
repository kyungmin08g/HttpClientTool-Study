package kyungmin.httpclienttoolstudy.feign_client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.logging.Level;

@Configuration
public class FeignClientConfig {

  /**
   * 로깅 범위 설정
   */
  @Bean
  public Level getLogLevel() {
    return Level.ALL;
  }
}
