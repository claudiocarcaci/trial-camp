package com.ccarcaci.trial;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinimumSwapsSpec {
  @Test
  public void example() {
    // setup
    int[] unordered = new int[] { 40, 23, 1, 7, 52, 31 };

    // run
    int minSwaps = MinSwaps.computate(unordered);

    // verify
    assertEquals(4, minSwaps);
  }
}
