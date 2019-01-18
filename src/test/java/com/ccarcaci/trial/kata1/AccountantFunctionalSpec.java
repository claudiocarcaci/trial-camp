package com.ccarcaci.trial.kata1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.powermock.api.mockito.PowerMockito.when;

public class AccountantFunctionalSpec {
  @Test
  public void specifySeparator() {
    // setup
    String input = "//[;]\n1;\n2;3,4;6,10\n1;0";

    // run
    long output = Accountant.computate(input);

    // verify
    assertEquals(27, output);
  }
}
