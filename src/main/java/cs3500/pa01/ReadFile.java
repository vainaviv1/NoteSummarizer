package cs3500.pa01;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Read the contents of the sorted files.
 */
public class ReadFile {
  /**
   * reads the content form the sorted files
   *
   * @param files the list of files to read
   * @return all the content in the  files as strings
   */
  public String readFromFile(ArrayList<File> files) {
    StringBuilder finalOutput = new StringBuilder();

    for (File file : files) {
      try (Scanner scanner = new Scanner(file)) {
        while (scanner.hasNextLine()) {
          String line = scanner.nextLine();
          if (line.startsWith("#")) {
            finalOutput.append("\n").append(line).append("\n");
          } else if (line.contains("[[")) {
            String importantPhrase;
            if (line.contains("]]")) {
              int startIndex = line.indexOf("[[") + 2;
              int endIndex = line.indexOf("]]");
              importantPhrase = line.substring(startIndex, endIndex);
            } else {
              importantPhrase = line.substring(line.indexOf("[[") + 2, line.length());
              line = scanner.nextLine();
              importantPhrase += line.substring(0, line.indexOf("]]"));
            }
                finalOutput.append("- ").append(importantPhrase).append("\n");

            }
          }
      } catch (Exception e) {
        System.err.println("Error occurred while reading file: " + file.getName());
      }
    }

    return finalOutput.toString();
  }
}


