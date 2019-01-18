package com.ccarcaci.trial;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Kata1Spec {
  @Test
  public void sumValues() {
    // setup
    String input = "";

    // run
    long total = Calculator.sumUp(input);

    // verify
    assertEquals(0, total);
  }

  @Test
  public void sumValues5() {
    // setup
    String input = "5";

    // run
    long total = Calculator.sumUp(input);

    // verify
    assertEquals(5, total);
  }

  @Test
  public void sumValues23() {
    // setup
    String input = "2,3";

    // run
    long total = Calculator.sumUp(input);

    // verify
    assertEquals(5, total);
  }

  @Test
  public void sumValues2357() {
    // setup
    String input = "2,3,5,7";

    // run
    long total = Calculator.sumUp(input);

    // verify
    assertEquals(17, total);
  }

  @Test
  public void sumValuesWithNewLineSeparator() {
    // setup
    String input = "2\n3\n5";

    // run
    long total = Calculator.sumUp(input);

    // verify
    assertEquals(10, total);
  }

  @Test
  public void sumValuesWithNewLineSeparator243578() {
    // setup
    String input = "2\n4,3\n5,7,8";

    // run
    long total = Calculator.sumUp(input);

    // verify
    assertEquals(29, total);
  }
}
