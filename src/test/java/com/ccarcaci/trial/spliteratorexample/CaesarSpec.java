package com.ccarcaci.trial.spliteratorexample;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertTrue;

public class CaesarSpec {
  @Test
  public void doActionOnSimpleSet() {
    // setup
    int limit = 10;
    int size = 20;
    List data = Arrays.asList(generateSomeStrings(size));

    // run
    List<String> result = Caesar.impera(limit, data);

    // verify
    assertTrue(data.containsAll(result) && result.containsAll(data));
  }

  @Test
  public void doActionOnLargeSet() {
    // setup
    int limit = 10;
    int size = 543;
    List data = Arrays.asList(generateSomeStrings(size));

    // run
    List<String> result = Caesar.impera(limit, data);

    // verify
    assertTrue(data.containsAll(result) && result.containsAll(data));
  }

  String[] generateSomeStrings(int size) {
    String[] generateds = new String[size];

    for(int i = 0; i < size; i++) {
      generateds[i] = UUID.randomUUID().toString();
    }

    return generateds;
  }
}
