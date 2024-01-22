package cs3500.pa01;

import static java.nio.file.FileVisitResult.CONTINUE;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

/**
 * tests the VisitFile class
 */
class VisitFileTest {
  /**
   * tests the visitfile method
   */
  @Test
  public void testVisitFile() throws IOException {
    File file = new File("sampleinput/arrays.md");
    ArrayList <Path> path = new ArrayList<Path>();
    VisitFile vf= new VisitFile(path);
    assertEquals(CONTINUE,vf.visitFile(Path.of("sampleinput/arrays.md"),
        Files.readAttributes(Path.of("sampleinput/arrays.md"), BasicFileAttributes.class)));
  }

  /**
   * tests the postVisitDirectory method
   */
  @Test
  public void testpostVisitDirectory() {
    File file = new File("sampleinput/arrays.md");
    ArrayList <Path> path = new ArrayList<Path>();
    VisitFile vf= new VisitFile(path);
    assertEquals(CONTINUE,vf.postVisitDirectory(Path.of("sampleinput/arrays.md"),
        new IOException()));
  }

  /**
   * tests the preVisitDirectory method
   */
  @Test
  public void testpreVisitDirectory() throws IOException {
    File file = new File("sampleinput/arrays.md");
    ArrayList <Path> path = new ArrayList<Path>();
    VisitFile vf= new VisitFile(path);
    assertEquals(CONTINUE,vf.preVisitDirectory(Path.of("sampleinput/arrays.md"),
        Files.readAttributes(Path.of("sampleinput/arrays.md"), BasicFileAttributes.class)));
  }

  /**
   * tests the visitFileFailed method
   */
  @Test
  public void testVisitFileFailed() {
    File file = new File("sampleinput/arrays.md");
    ArrayList <Path> path = new ArrayList<Path>();
    VisitFile vf= new VisitFile(path);
    assertEquals(CONTINUE,vf.visitFileFailed(Path.of("sampleinput/arrays.md"),
        new IOException()));
  }

}