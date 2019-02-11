package com.ccarcaci.trial.glitch;

import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.fail;

public class VerifyGlitch {
  @Test
  public void parallel() {
    // setup
    int[] indexes = IntStream.range(0, 80).toArray();

    // run
    int[][] ticks = Tick.pin(indexes);
    int[][] ticksP = Tick.pinP(indexes);

    // verify
    fail();
  }
}
