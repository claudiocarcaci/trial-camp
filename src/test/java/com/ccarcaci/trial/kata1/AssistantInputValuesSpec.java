package com.ccarcaci.trial.kata1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AssistantInputValuesSpec {
  @Test
  public void inputValuesWithoutCustomSeparators() {
    // setup
    String input = "1,2,3";

    // run
    String inputValues = Accountant.Assistant.getInputValues(input);

    // verify
    assertEquals("1,2,3", inputValues);
  }

  @Test
  public void inputValuesWithCustomSeparators() {
    // setup
    String input = "//[;]\n4;5;6";

    // run
    String inputValues = Accountant.Assistant.getInputValues(input);

    // verify
    assertEquals("4;5;6", inputValues);
  }
}
