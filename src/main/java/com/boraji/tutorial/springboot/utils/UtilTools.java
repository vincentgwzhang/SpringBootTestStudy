package com.boraji.tutorial.springboot.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UtilTools {

  private int var1;

  private String var2;

  public void function1() {
    System.out.println("function1");
  }

  public void function2() {
    System.out.println("function2");
  }
}
