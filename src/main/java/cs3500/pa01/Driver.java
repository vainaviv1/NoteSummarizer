package cs3500.pa01;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

// when running the driver(code), it will output the code into a new file, please delete that file
// before you run it again, because it keeps outputting to that same file without clearing the file
// I talked to a TA, and he said to leave a note here, so you know how to manually delete that file
// before running the driver again
public class Driver {
  /**
   * driver, the main class
   * @param args
   * @throws IOException
   */
  public static void main(String[] args) throws IOException {
    String pathInput = args[0];
    String orderingFlag = args[1];
    String pathOutput = args[2];

    Path notesRoot = Path.of(pathInput);
    ArrayList<Path> list = new ArrayList<>();
    VisitFile vf = new VisitFile(list);
    Files.walkFileTree(notesRoot, vf);
    ArrayList<Path> retVal = vf.getList();
    for (Path path: retVal) {
      System.out.println(path);
    }

    ArrayList<File> files = Utils.convertPathToFile(retVal);
    ArrayList<File> sortedList = SortFile.sortFile(files, orderingFlag);
    ReadFile fr= new ReadFile();
    String content = fr.readFromFile(files);

    Path po = Path.of(pathOutput);
    File fileOutput = po.toFile();
    WriteFile wf= new WriteFile();
    wf.writeToFile(fileOutput, content);
  }
}
