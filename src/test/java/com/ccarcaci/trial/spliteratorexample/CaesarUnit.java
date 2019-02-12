package com.ccarcaci.trial.spliteratorexample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.verifyStatic;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Caesar.Kingdom.class)
public class CaesarUnit {
  @Test
  public void doActionOnMinimalSet() {
    // setup
    mockStatic(Caesar.Kingdom.class);

    int limit = 11;
    int size = 10;
    List data = Arrays.asList(generateSomeStrings(size));

    // run
    Caesar.impera(limit, data);

    // verify
    verifyStatic(Caesar.Kingdom.class, times(1));
    Caesar.Kingdom.war(any());
  }

  @Test
  public void doActionOnLargeSet() {
    // setup
    mockStatic(Caesar.Kingdom.class);

    int limit = 11;
    int size = 20;
    List data = Arrays.asList(generateSomeStrings(size));

    // run
    Caesar.impera(limit, data);

    // verify
    verifyStatic(Caesar.Kingdom.class, times(2));
    Caesar.Kingdom.war(any());
  }

  String[] generateSomeStrings(int size) {
    String[] generateds = new String[size];

    for(int i = 0; i < size; i++) {
      generateds[i] = UUID.randomUUID().toString();
    }

    return generateds;
  }
}
