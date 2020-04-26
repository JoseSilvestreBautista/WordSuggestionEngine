package com.company;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class extracts all messages from a text file and stores them in an ArrayList. It inserts the
 * each line of message as an element in the ArrayList.
 *
 * @author Jose Silvestre-Bautista
 */
public class GettingLines {

  public ArrayList<String> currentList = new ArrayList<>();
  public File messages = new File("src/com/company/messages.txt");

  /**
   * Reads the messages.txt file and inserts each line as an element of the ArrayList.
   */
  public void readingFile() {
    String currentLine = null;

    try {
      Scanner readingMessages = new Scanner(messages);
      while (readingMessages.hasNextLine()) {
        String line = readingMessages.nextLine().toLowerCase();
        currentList.add(line);
      }
      readingMessages.close();
    } catch (Exception e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
//    printList();
  }

  /**
   * Print the contents of the ArrayList currentList
   */
  public void printList() {
    System.out.println(currentList);
  }

}