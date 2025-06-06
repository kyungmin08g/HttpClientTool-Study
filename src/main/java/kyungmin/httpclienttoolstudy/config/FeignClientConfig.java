package kyungmin.httpclienttoolstudy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.logging.Level;

@Configuration
public class FeignClientConfig {

  @Bean
  public Level getLogLevel() {
    return Level.ALL;
  }

}
