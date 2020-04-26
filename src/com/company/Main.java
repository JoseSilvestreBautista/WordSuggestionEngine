package com.company;

import java.util.Scanner;

/**
 * Serves as the driver class where all other classes and their methods are called. The program
 * accepts single worded answers and based on prior messages it suggests a next word.
 *
 * @author Jose Silvestre-Bautista
 */
public class Main {


  /**
   * The driver method, it calls the proper objects in the proper order to run the program.
   *
   * @param args the input arguments
   */
  public static void main(String[] args) {
    GettingLines bow = new GettingLines();
    bow.readingFile();

    Bigram bigram = new Bigram();
    bigram.createTreeMap(bow.currentList);
//        bigram.printWordsByValue();

    AffinityAnalysis analysis = new AffinityAnalysis();
    analysis.wordSupport(bigram.map);

    Scanner userInput = new Scanner(System.in);
    String word = userInput.nextLine().toLowerCase();
    analysis.Suggestion(word);

  }
}
