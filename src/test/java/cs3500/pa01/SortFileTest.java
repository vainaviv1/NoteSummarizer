package cs3500.pa01;

import org.junit.jupiter.api.Test;
import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SortFileTest {


  /**
   * Tests sorting files by filename.
   */
  @Test
  public void testSortFileByFilename() {
    SortFile sf= new SortFile();
    ArrayList<File>files = new ArrayList<>();
    files.add(new File("arrays.md"));
    files.add(new File("vectors.md"));
    sf.sortFile(files, "filename");
    assertEquals(files, sf.sortFile(files, "filename"));
  }





  /**
   * Tests sorting files by modified date.
   */
  @Test
  public void testSortFileByModified() {
    SortFile sf= new SortFile();
    ArrayList<File>files = new ArrayList<>();
    files.add(new File("vectors.md"));
    files.add(new File("arrays.md"));
    sf.sortFile(files, "filename");
    assertEquals(files, sf.sortFile(files, "modified"));
  }





  /**
   * Tests sorting files by creation time.
   */
  @Test
  public void testSortFileByCreated() {
    SortFile sf= new SortFile();
    ArrayList<File>files = new ArrayList<>();
    files.add(new File("sampleinput/arrays.md"));
    files.add(new File("sampleinput/vectors.md"));
    sf.sortFile(files, "created");
    assertEquals(files, sf.sortFile(files, "created"));
  }

  /**
   * Tests sorting files with an invalid ordering flag.
   */
  @Test
  public void testSortFileWithInvalidFlag() {
    SortFile sf = new SortFile();
    ArrayList<File>files = new ArrayList<>();
    files.add(new File("arrays.md"));
    files.add(new File("vectors.md"));
    assertThrows(IllegalArgumentException.class,
        () -> new SortFile().sortFile(files, "invalid"));
  }

  /**
   * tests the getSortFile methods
   */
  @Test
  public void testGetSortFile() {
    SortFile sf = new SortFile();
    ArrayList<File>files = new ArrayList<>();
    files.add(new File("arrays.md"));
    files.add(new File("vectors.md"));
    ArrayList<File> sortedList = SortFile.sortFile(files, "filename");
    assertEquals(sortedList, sf.getSortFile(files, "filename"));
  }

  /**
   * tests the path to file conversion class
   */
  @Test
  public void testPathToFileConversion() {
    // Create a list of paths
    ArrayList<Path> paths = new ArrayList<>();
    paths.add(Path.of("path1"));
    paths.add(Path.of("path2"));

    // Convert paths to files
    ArrayList<File> files = Utils.convertPathToFile(paths);

    // Check if the conversion is correct
    assertEquals(2, files.size());
    assertEquals("path1", files.get(0).getPath());
    assertEquals("path2", files.get(1).getPath());
  }
}