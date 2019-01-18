package com.ccarcaci.trial;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Kata1SeparatorSpec {
  @Test
  public void specifySeparator() {
    // setup
    String input = "//[;]\n1;2;3";

    // run
    long output = Calculator.sumUp(input);

    // verify
    assertEquals(6, output);
  }
}
