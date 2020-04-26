package com.company;

import java.util.ArrayList;
import java.util.Map;

/**
 * This class splits the hashmap values into three ArrayList: one for the first word, second word,
 * and number times the pair occurs. Using the ArrayLists a support is calculated for word entered
 * by the user, and only words with supports greater than 65% are suggested.
 *
 * @author Jose Silveste-Bautista
 */
public class AffinityAnalysis {

  ArrayList<String> firstWord = new ArrayList<>();
  ArrayList<String> lastWord = new ArrayList<>();
  ArrayList<Integer> occurrence = new ArrayList<>();

  /**
   * Splits the info from the hashmap into three ArrayList. A list for the first word in a pair, a
   * list for the word after the first, and a list for the occurrence of the pair.
   *
   * @param map the pairs and the occurrences of pair
   */
  public void wordSupport(Map<ArrayList<String>, Integer> map) {
    map.forEach((key, value) -> firstWord.add(new ArrayList<>(key).get(0)));
    map.forEach((key, value) -> lastWord.add(new ArrayList<>(key).get(1)));
    map.forEach((key, value) -> occurrence.add(value));
  }

  /**
   * Takes a word from the user, and suggests the next word to be used based on second word list.
   * Then calculates a support for the second word, if the support is above 65% the word is
   * suggested, else a default suggestion is made: "the", "this", and "of".
   *
   * @param word the word entered by the user.
   */
  public void Suggestion(String word) {
    ArrayList<Integer> indexForSecondWord = new ArrayList<>();
    int total = 0;
    for (int i = 0; i < firstWord.size(); i++) {
      if (word.equals(firstWord.get(i))) {
        total += occurrence.get(i);
        indexForSecondWord.add(i);
      }
    }

    for (Integer integer : indexForSecondWord) {
      double percent = (occurrence.get(integer) / (float) total) * 100;
      System.out
          .println("\"" + lastWord.get(integer) + "\"" + " has " + percent
              + " popularity");
    }

    for (Integer integer : indexForSecondWord) {
      if (((occurrence.get(integer) / (float) total) * 100 > 65)) {
        System.out.println("\n" +
            "For your word: " + "\"" + word + "\"" + " We recommend: " + "\"" + lastWord
            .get(integer) + "\"");
        return;
      }
    }

    System.out.println(
        "For your word: " + "\"" + word + "\"" + " We recommend: " + "\"the\", \"this\" , \"of\"");
  }

}




