package com.ccarcaci.trial.kata1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AssistantSplitSpec {
  @Test
  public void singleNumber() {
    // setup
    String input = "1";

    // run
    String[] values = Accountant.Assistant.splitByDefaults(input);

    // verify
    assertEquals(1, values.length);
    assertEquals("1", values[0]);
  }

  @Test
  public void values23() {
    // setup
    String input = "2,3";

    // run
    String[] values = Accountant.Assistant.splitByDefaults(input);

    // verify
    assertEquals(2, values.length);
    assertEquals("2", values[0]);
    assertEquals("3", values[1]);
  }

  @Test
  public void complexInput() {
    // setup
    String input = "2\n4,3\n5,7,8";

    // run
    String[] values = Accountant.Assistant.splitByDefaults(input);

    // verify
    assertEquals(6, values.length);
    assertEquals("2", values[0]);
    assertEquals("4", values[1]);
    assertEquals("3", values[2]);
    assertEquals("5", values[3]);
    assertEquals("7", values[4]);
    assertEquals("8", values[5]);
  }

  @Test
  public void customSeparator() {
    // setup
    String[] input = new String[] { "2;3" };
    String customSeparatorRegex = "[;]";

    // run
    String[] values = Accountant.Assistant.splitByCustom(input, customSeparatorRegex);

    // verify
    assertEquals(2, values.length);
    assertEquals("2", values[0]);
    assertEquals("3", values[1]);
  }

  @Test
  public void customSeparatorWithComplexInput() {
    // setup
    String[] input = new String[] { "2;3", "1;2;3", "0;1;20" };
    String customSeparatorRegex = "[;]";

    // run
    String[] values = Accountant.Assistant.splitByCustom(input, customSeparatorRegex);

    // verify
    assertEquals(8, values.length);
    assertEquals("2", values[0]);
    assertEquals("3", values[1]);
    assertEquals("1", values[2]);
    assertEquals("2", values[3]);
    assertEquals("3", values[4]);
    assertEquals("0", values[5]);
    assertEquals("1", values[6]);
    assertEquals("20", values[7]);
  }
}
