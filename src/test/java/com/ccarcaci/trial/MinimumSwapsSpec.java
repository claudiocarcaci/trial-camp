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
    assertEquals(5, minSwaps);
  }

  @Test
  public void example2() {
    // setup
    int[] unordered = new int[] { 4, 3, 2, 1 };

    // run
    int minSwaps = MinSwaps.computate(unordered);

    // verify
    assertEquals(2, minSwaps);
  }

  @Test
  public void example3() {
    // setup
    int[] unordered = new int[] {1, 5, 4, 3, 2};

    // run
    int minSwaps = MinSwaps.computate(unordered);

    // verify
    assertEquals(2, minSwaps);
  }
}
