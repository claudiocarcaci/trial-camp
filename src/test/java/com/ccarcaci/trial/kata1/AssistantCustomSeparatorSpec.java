package com.ccarcaci.trial.kata1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AssistantCustomSeparatorSpec {
  @Test
  public void customSeparatorsNotFound() {
    // setup

    // run
    String separatorsRegex = Accountant.Assistant.getCustomSeparatorsRegex("1,2,3");

    // verify
    assertEquals("", separatorsRegex);
  }

  @Test
  public void customSeparators() {
    // setup
    String input = "//[;]\n1;2;3";

    // run
    String separatorsRegex = Accountant.Assistant.getCustomSeparatorsRegex(input);

    // verify
    assertEquals("[;]", separatorsRegex);
  }
}
