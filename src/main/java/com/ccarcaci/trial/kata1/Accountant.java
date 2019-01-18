package com.ccarcaci.trial.kata1;

import java.util.stream.Stream;

public class Accountant {
  public static long computate(String input) {
    if(input.equals("")) {
      return 0;
    } else {
      String customSeparatorsRegex = Assistant.getCustomSeparatorsRegex(input); // Stateless function
      String valuesInput = Assistant.getInputValues(input); // Stateless function

      String[] defaultSeparatorsValues = Assistant.splitByDefaults(valuesInput);
      String[] allValues = Assistant.splitByCustom(defaultSeparatorsValues, customSeparatorsRegex);

      return Stream.of(allValues).mapToLong(Long::parseLong).sum();
    }
  }

  static class Assistant {
    // Stateless function
    static String getCustomSeparatorsRegex(String input) {
      if(input.startsWith("//")) {
        int customSeparatorEndPosition = input.indexOf("\n");

        return input.substring(0, customSeparatorEndPosition).
            replaceFirst("//", "");
      } else { return ""; }
    }

    // Stateless function
    static String getInputValues(String input) {
      if(input.startsWith("//")) {
        int customSeparatorEndPosition = input.indexOf("\n");

        return input.substring(customSeparatorEndPosition + 1);
      } else { return input; }
    }

    static String[] splitByDefaults(String valuesInput) {
      return new String[] { "" };
    }

    static String[] splitByCustom(String[] defaultSeparatorsValues, String customSeparatorsRegex) {
      return new String[] { "" };
    }
  }
}
