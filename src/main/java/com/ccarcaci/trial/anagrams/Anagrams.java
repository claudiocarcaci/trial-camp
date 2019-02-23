package com.ccarcaci.trial.anagrams;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Anagrams {
  private static String[] wordsFiles = new String[] {
      "data/paroleitaliane/paroleitaliane/lista_badwords.txt",
      "data/paroleitaliane/paroleitaliane/parole_uniche.txt"
  };
  private static Map<String, String[]> dictio = null;
  private static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

  public static String[] findOf(String term) throws FileNotFoundException {
    if(dictio == null) { load(); }

    String fingerprint = fingerprint(term);

    return dictio.get(fingerprint);
  }

  public static Map<String, String[]> getDictio() throws FileNotFoundException {
    if(dictio == null) { load(); }

    return dictio;
  }

  private static void load() throws FileNotFoundException {
    Scanner scanner;
    dictio = new HashMap<>();

    for(String fileName : wordsFiles) {
      scanner = new Scanner(new File(fileName));

      while(scanner.hasNextLine()) {
        String term = scanner.nextLine();
        String fingerprint = fingerprint(term);
        String[] fingerWords = dictio.get(fingerprint);

        if(Objects.isNull(fingerWords)) {
          fingerWords = new String[] { term };
          dictio.put(fingerprint, fingerWords);
        } else {
          int size = fingerWords.length;
          String[] fingerWordsUpdated = Arrays.copyOf(fingerWords, size + 1);
          fingerWordsUpdated[size] = term;

          dictio.put(fingerprint, fingerWordsUpdated);
        }
      }
    }
  }

  public static String fingerprint(String term) {
    String claim = term.toUpperCase();
    StringBuilder fingerprintSB = new StringBuilder("00000000000000000000000000");

    for(int i = 0; i < claim.length(); i++) {
      String fingerprint = fingerprintSB.toString();
      int fingerprintIndex = alphabet.indexOf(Character.toString(claim.charAt(i)));

      if(fingerprintIndex < 0) { continue; }

      int value = fingerprint.charAt(fingerprintIndex) - '0' + 1;
      fingerprintSB.replace(fingerprintIndex, fingerprintIndex + 1, "" + value + "");
    }

    return fingerprintSB.toString();
  }
}
