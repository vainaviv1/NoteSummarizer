package cs3500.pa01;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;

///**
 //* converts paths to files
// *
 //* @param  path Array List of paths
// * @return the compressed output as a string
 //*/
public class Utils {
  public static ArrayList<File> convertPathToFile(ArrayList<Path> paths) {
    ArrayList<File> files = new ArrayList<>();
    for (Path path : paths) {
      files.add(path.toFile());
    }
    return files;
  }
}
