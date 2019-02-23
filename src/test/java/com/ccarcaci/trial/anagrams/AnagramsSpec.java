package com.ccarcaci.trial.anagrams;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class AnagramsSpec {
  @Test
  public void find() throws FileNotFoundException {
    // setup

    // run
    String[] anagrams = Anagrams.findOf("caso");

    // verify
    assertTrue(Arrays.asList(anagrams).contains("cosa"));
  }

  @Test
  public void findAndPrint() throws FileNotFoundException {
    String[] anagrams = Anagrams.findOf("levirato");

    Arrays.asList(anagrams).forEach(System.out::println);
  }

  @Test
  public void printAllAnagrams() throws IOException {
    Map<String, String[]> dictio = Anagrams.getDictio();
    FileWriter fileWriter = new FileWriter("data/paroleitaliane/paroleitaliane/anagrams.txt");

    dictio.forEach((fingerprint, anagrams) -> {
      try {
        fileWriter.write(fingerprint + "\n");
      } catch (IOException e) {
        throw new RuntimeException(e);
      }

      Arrays.asList(anagrams).forEach(str -> {
        try {
          fileWriter.write(str + "\n");
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      });

      try {
        fileWriter.write("---\n");
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    });

    fileWriter.close();
  }
}
