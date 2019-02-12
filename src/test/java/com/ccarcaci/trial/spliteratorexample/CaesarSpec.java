package com.ccarcaci.trial.spliteratorexample;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

import static org.junit.Assert.assertTrue;

public class CaesarSpec {
  @Test
  public void doActionOnLargeSet() {
    // setup
    int limit = 10;
    int size = 20;
    String[] data = generateSomeStrings(size);
    Stream dataStream = Stream.of(data);

    // run
    List<String> result = Caesar.impera(limit, dataStream);

    // verify
    assertTrue(Arrays.asList(data).containsAll(result) && result.containsAll(Arrays.asList(data)));
  }

  String[] generateSomeStrings(int size) {
    String[] generateds = new String[size];

    for(int i = 0; i < size; i++) {
      generateds[i] = UUID.randomUUID().toString();
    }

    return generateds;
  }
}
