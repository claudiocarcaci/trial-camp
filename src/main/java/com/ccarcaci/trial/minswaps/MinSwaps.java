package com.ccarcaci.trial.minswaps;

import java.util.Arrays;

public class MinSwaps {
  public static int computate(int[] unordered) {
    int size = unordered.length;
    int[] ordered = order(unordered);
    int[] realPositions = realPositions(ordered, unordered);
    boolean[] touchs = new boolean[size];
    Arrays.fill(touchs, false);
    int i;
    int landing;
    int swaps = 0;

    for(i = 0; i < size; i++) {
      if(!touchs[i]) {
        landing = realPositions[i];

        while(!touchs[landing]) {
          touchs[landing] = true;
          landing = realPositions[landing];

          if(!touchs[landing]) { swaps++; }
        }
      }
    }

    return swaps;
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
