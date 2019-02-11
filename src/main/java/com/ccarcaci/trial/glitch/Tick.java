package com.ccarcaci.trial.glitch;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

public class Tick {
  public static int[][] pin(int[] indexes) {
    int[][] ticks = new int[indexes.length][indexes.length];

    IntStream.of(indexes)
        .boxed()
        .forEach(row -> IntStream.of(indexes)
            .boxed()
            .forEach(col -> ticks[row][col] = 1));

    return ticks;
  }

  public static int[][] pinP(int[] indexes) {
    int[][] ticks = new int[indexes.length][indexes.length];

    IntStream.of(indexes)
        .boxed()
        .parallel()
        .forEach(row -> IntStream.of(indexes)
            .boxed()
            .forEach(col -> ticks[row][col] = 1));

    return ticks;
  }
}
