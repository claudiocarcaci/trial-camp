package com.ccarcaci.trial.glitch;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class ObjectsHashGlitch {
  @Test
  public void putParallel() {
    // setup
    Supplier<IntStream> intStreamSupplier = () -> IntStream.range(0, 10000);
    Map<Integer, Integer> expectedValues = new ConcurrentHashMap<>();
    Map<Integer, Integer> valuesParallel = new ConcurrentHashMap<>();

    // run
    intStreamSupplier.get()
        .forEach(value -> expectedValues.put(value, value));
    intStreamSupplier.get()
        .parallel()
        .forEach(value -> valuesParallel.put(value, value));

    // verify
    assertEquals(expectedValues.size(), valuesParallel.size());
  }
}
