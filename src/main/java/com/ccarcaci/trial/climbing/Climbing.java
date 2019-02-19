package com.ccarcaci.trial.climbing;

// https://www.coderbyte.com/algorithm/step-by-step-solution-step-walking-using-recursion
public class Climbing {
  public static int paths(int stepsCount) {
    if(stepsCount <= 3) { return stepsCount; }

    return paths(stepsCount - 1) + paths(stepsCount - 2);
  }
}
