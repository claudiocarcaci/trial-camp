package com.ccarcaci.trial.climbing;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
// https://www.coderbyte.com/algorithm/step-by-step-solution-step-walking-using-recursion
public class ClimbingTest {
  private int input;
  private int expected;

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][] { { 0, 0 }, { 1, 1 }, { 2, 2 }, { 3, 3 }, { 4, 5 }, { 5, 8 } });
  }

  public ClimbingTest(int input, int expected) {
    this.input = input;
    this.expected = expected;
  }

  @Test
  public void countWays() {
    // setup

    // run
    int waysCount = Climbing.paths(input);

    // verify
    assertEquals(expected, waysCount);
  }
}
