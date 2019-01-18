package com.ccarcaci.trial.kata1;

import com.ccarcaci.trial.kata1.Accountant;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Accountant.Assistant.class)
public class AccountantWithCustomSeparatorSpec {
  @Before
  public void setup() {
    mockStatic(Accountant.Assistant.class);
  }

  @Test
  public void specifySeparator() {
    // setup
    String input = "//[;]\n1;2;3";

    when(Accountant.Assistant.getCustomSeparatorsRegex(input)).
        thenReturn("[;]");
    when(Accountant.Assistant.getInputValues(input)).
        thenReturn("1;2;3");
    when(Accountant.Assistant.splitByDefaults("1;2;3")).
        thenReturn(new String[] { "1;2;3" });
    when(Accountant.Assistant.splitByCustom(new String[] { "1;2;3" }, "[;]")).
        thenReturn(new String[] { "1", "2", "3" });

    // run
    long output = Accountant.computate(input);

    // verify
    assertEquals(6, output);
  }
}
