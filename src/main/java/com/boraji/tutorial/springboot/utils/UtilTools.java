package com.boraji.tutorial.springboot.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class UtilTools {

  private int var1;

  private String var2;

  public void function1() {
    log.info("function1");
  }

  public void function2() {
    log.info("function2");
  }
}
