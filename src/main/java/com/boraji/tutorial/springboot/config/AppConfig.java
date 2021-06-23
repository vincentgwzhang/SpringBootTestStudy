package com.boraji.tutorial.springboot.config;

import com.boraji.tutorial.springboot.utils.UtilTools;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

  @Bean
  public UtilTools utilTools() {
    return new UtilTools();
  }

}
