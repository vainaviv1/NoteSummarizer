package cs3500.pa01;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import org.junit.jupiter.api.Test;

/**
 * tests the WriteFile class
 */
class WriteFileTest {

  /**
   * tests the writeToFile method
   */
  @Test
  public void testwriteToFile() {
    WriteFile wf = new WriteFile();
    ReadFile rf = new ReadFile();
    File file = new File("sampleinput/finaltest.md");
    String contents = ("hello"+"\n"+"bye"+"\n");
    wf.writeToFile(file, contents);
    Scanner sc;
    try {
      sc = new Scanner(file);
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
    StringBuffer sb = new StringBuffer();
    while(sc.hasNext()) {
      sb.append(sc.nextLine()+"\n");
    }
    assertEquals(contents, sb.toString());

  }

  @Test
  public void testWriteFileFailed() {
    SortFile sf = new SortFile();
    ArrayList<File> files = new ArrayList<>();
    files.add(new File("arrays.md"));
    files.add(new File("vectors.md"));
    assertThrows(IllegalArgumentException.class,
        () -> new SortFile().sortFile(files, "invalid"));
  }


}