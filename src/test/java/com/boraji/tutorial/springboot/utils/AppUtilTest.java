package com.boraji.tutorial.springboot.utils;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class AppUtilTest {

  AppUtil appUtil = new AppUtil();

  @Test
  public void whenEmptyString_thenAccept() {
    assertTrue(appUtil.isPalindrome(""));
  }
}
