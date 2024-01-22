package cs3500.pa01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {
  private ArrayList<Path> testPaths;

  @BeforeEach
  void setUp() {
    // Initialize the test paths
    testPaths = new ArrayList<>();
    testPaths.add(Path.of("path1.txt"));
    testPaths.add(Path.of("path2.txt"));
    testPaths.add(Path.of("path3.txt"));
  }

  /**
   * tests the convert path to file class
   */
  @Test
  void testConvertPathToFile() {
    ArrayList<File> expectedFiles = new ArrayList<>();
    expectedFiles.add(new File("path1.txt"));
    expectedFiles.add(new File("path2.txt"));
    expectedFiles.add(new File("path3.txt"));

    ArrayList<File> convertedFiles = Utils.convertPathToFile(testPaths);

    assertEquals(expectedFiles.size(), convertedFiles.size());
    for (int i = 0; i < expectedFiles.size(); i++) {
      assertEquals(expectedFiles.get(i), convertedFiles.get(i));
    }
  }
}
