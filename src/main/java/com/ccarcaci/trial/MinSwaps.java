package com.ccarcaci.trial;

import java.util.Arrays;
import java.util.Collections;

public class MinSwaps {
  public static int computate(int[] unordered) {
    int[] ordered = order(unordered);
    int[] realPositions = realPositions(ordered, unordered);

    return 0;
  }

  private static int[] realPositions(int[] ordered, int[] unordered) {
    int i;
    int[] positions = new int[unordered.length];

    for(i = 0; i < unordered.length; i++) {
      positions[i] = position(ordered, unordered[i]);
    }

    return positions;
  }

  private static int position(int[] ordered, int value) {
    int i;

    for(i = 0; i < ordered.length; i++) {
      if(ordered[i] == value) {
        return i;
      }
    }

    return -1;
  }

  private static int[] order(int[] unordered) {
    int[] ordered = unordered.clone();
    Arrays.sort(ordered);

    return ordered;
  }
}
