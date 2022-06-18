package com.boraji.tutorial.springboot.config;

import com.boraji.tutorial.springboot.utils.UtilTools;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ContextConfiguration(classes=AppConfig.class, loader= AnnotationConfigContextLoader.class)
@TestPropertySource("classpath:application.properties")// 一定要加这个
class AppConfigTest {

  @Autowired
  private UtilTools utilTools;

  @Test
  void testIfUtilTools() {
    assertThat(utilTools).isNotNull();
    assertThat(utilTools.getVar1()).isEqualTo(123);
    assertThat(utilTools.getVar2()).isEqualTo("abc");
  }

}
