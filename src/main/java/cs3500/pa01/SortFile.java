package cs3500.pa01;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortFile {

  /**
   * sorts the files based on the ordering flag
   *
   * @param files the list of files to sort
   * @return the compressed output as a string
   */
  public static ArrayList<File> sortFile(ArrayList<File> files, String orderingFlag) {
    switch (orderingFlag) {
      case "modified":
        files.sort(Comparator.comparingLong(File::lastModified));
        Collections.reverse(files);
        break;
      case "filename":
        files.sort(Comparator.comparing(File::getName));
        break;
      case "created":
        files.sort(Comparator.comparing(file -> {
          try {
            BasicFileAttributes attributes = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
            return attributes.creationTime();
          } catch (IOException e) {
            throw new IllegalArgumentException("wrong");
          }
        }));
        break;
      default:
        throw new IllegalArgumentException ("Invalid ordering flag. Please provide a valid ordering flag.");
    }
    return files;
  }

  public static ArrayList<File> getSortFile(ArrayList<File> files, String orderingFlag) {
    ArrayList<File> sortedFile = new ArrayList<>(files);
    return sortFile(sortedFile, orderingFlag);
  }
}