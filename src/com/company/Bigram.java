package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * This class takes the ArrayList currentList and puts it into a hashmap, where it takes pairs of
 * words from a line and counts how many times that pair combo occurs in the currentList.
 *
 * @author Jose Silvestre-Bautista
 */
public class Bigram {

  //maps for handling word(tokens)
  public Map<ArrayList<String>, Integer> map = new HashMap<>();

  /**
   * Takes pairs of word from each line and counts the number of times it occurs.
   *
   * @param currentList the lines from the txt file.
   */
  public void createTreeMap(ArrayList<String> currentList) {

    for (String s : currentList) {
      String[] list = s.split("\\s");
      for (int j = 1; j < list.length; j++) {
        map.merge(new ArrayList<>(Arrays.asList(list[j - 1], list[j])), 1, Integer::sum);
      }
    }

  }

  /**
   * Prints the entire hashmap.
   */
  public void printWordsByValue() {
    map.forEach((key, value) -> System.out.println(key + "," + value));

  }

}


