package com.ccarcaci.trial.anagrams;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FingerprintSpec {
  private String term;
  private String expected;

  // "10000000100010330001000000"
  // "abcdefghijklmnopqrstuvqxyz"
  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][] {
        { "a",  "10000000000000000000000000" },
        { "ab", "11000000000000000000000000" },
        { "abcdefghijklmnopqrstuvwxyz", "11111111111111111111111111" },
        { "ippopotamo", "10000000100010330001000000" }
    });
  }

  public FingerprintSpec(String term, String fingerprint) {
    this.term = term;
    this.expected = fingerprint;
  }

  @Test
  public void minimal() {
    // setup

    // run
    String fingerprint = Anagrams.fingerprint(term);

    // verify
    assertEquals(expected, fingerprint);
  }
}
