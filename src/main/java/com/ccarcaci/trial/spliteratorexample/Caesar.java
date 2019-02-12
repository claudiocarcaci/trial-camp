package com.ccarcaci.trial.spliteratorexample;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Caesar {
  public static List<String> impera(int limit, Stream data) {
    Spliterator spliterator = data.spliterator();
    List<Spliterator> spliterators = new ArrayList<>();
    spliterators.add(spliterator);

    while(spliterator.estimateSize() > limit) {
      spliterators.add(spliterator.trySplit());
    }

    return spliterators.stream()
        .flatMap(innerIterator -> {
          List dataSplit = new ArrayList<>(0);
          innerIterator.forEachRemaining(dataSplit::add);

          return Kingdom.war(dataSplit).stream();
        })
        .collect(Collectors.toList());
  }

  public static class Kingdom {
    public static List<String> war(List data) {
      System.out.println(data);

      return data;
    }
  }
}
