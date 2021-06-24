package com.boraji.tutorial.springboot.config;

import com.boraji.tutorial.springboot.utils.UtilTools;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

  @Value("${application.appconfig.var1}")
  private int variable1;

  @Value("${application.appconfig.var2}")
  private String variable2;

  @Bean
  public UtilTools utilTools() {
    return new UtilTools(variable1, variable2);
  }

}
