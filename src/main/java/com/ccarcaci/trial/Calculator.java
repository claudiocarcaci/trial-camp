package com.ccarcaci.trial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Calculator {
  public static long sumUp(String input) {
    if(input.equals("")) {
      return 0;
    } else {
      List sovraValues;
      String customSeparators = "";

      if(input.startsWith("//")) {
        String[] separatorsRegexAndInput = input.replaceFirst("//", "").split("\n");

        customSeparators = separatorsRegexAndInput[0];
        sovraValues = Arrays.stream(separatorsRegexAndInput).
            skip(1).
            collect(Collectors.toList());
      }  else {
        sovraValues = new ArrayList();
        sovraValues.add(input);
      }

      String finalCustomSeparators = customSeparators;
      return sovraValues.stream().
          flatMap(sovraValue -> Stream.concat(
              Stream.of(sovraValue.split("[,\n]")),
              Stream.of(sovraValue.split(finalCustomSeparators)))).
              mapToLong(Long::parseLong).
          sum();
    }
  }

  private static String getSeparatorsRegex(String input) {
    if(input.startsWith("//")) {
      String separators = input.replace("//", "").split("\n")[0];

      return separators;
    } else {
      return "";
    }
  }
}
