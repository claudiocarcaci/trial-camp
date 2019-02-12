package com.ccarcaci.trial.spliteratorexample;

import org.junit.Test;

import java.util.Spliterator;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class Tailoring {
  @Test
  public void cutFabric() {
    // setup
    Supplier<IntStream> intSupplier = () -> IntStream.range(0, 10);

    // run
    Spliterator spliterator = intSupplier.get()
        .spliterator();
    Spliterator anotherOne = spliterator.trySplit();

    System.out.println("Second one");
    anotherOne.forEachRemaining(System.out::println);
    System.out.println("First one");
    spliterator.forEachRemaining(System.out::println);
    // verify
  }
}
