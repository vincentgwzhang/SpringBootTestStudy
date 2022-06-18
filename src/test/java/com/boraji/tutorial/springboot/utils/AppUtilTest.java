package com.boraji.tutorial.springboot.utils;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class AppUtilTest {

  AppUtil appUtil = new AppUtil();

  @Test
  void whenEmptyString_thenAccept() {
    assertTrue(appUtil.isPalindrome(""));
  }
}
