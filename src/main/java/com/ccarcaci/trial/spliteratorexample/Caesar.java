package com.ccarcaci.trial.spliteratorexample;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

public class Caesar {
  public static List<String> impera(int limit, List data) {
    Spliterator spliterator = data.spliterator();

    if(spliterator.estimateSize() < limit) {
      return Kingdom.war(data);
    } else {
      Spliterator splitting = spliterator.trySplit();

      List firstHalf = new ArrayList<>(0);
      spliterator.forEachRemaining(firstHalf::add);

      List secondHalf = new ArrayList<>(0);
      splitting.forEachRemaining(secondHalf::add);

      List result = impera(limit, firstHalf);
      result.addAll(impera(limit, secondHalf));

      return result;
    }
  }

  public static class Kingdom {
    public static List<String> war(List data) {
      System.out.println(data);

      return data;
    }
  }
}
