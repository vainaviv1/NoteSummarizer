package cs3500.pa01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DriverTest {
  private static final String TEST_INPUT_PATH = "test/input/input.md";
  private static final String TEST_OUTPUT_PATH = "test/output/output.md";
  private static final String ORDERING_FLAG = "filename";

  @BeforeEach
  void setUp() throws IOException {
    // Create the test directories if they don't exist
    //Files.createDirectories(Path.of(TEST_INPUT_PATH));
    //Files.createDirectories(Path.of(TEST_OUTPUT_PATH));
  }

  /**
   * tests the driver class
  // */
  @Test
  void testMain() throws IOException {
    String[] args = {TEST_INPUT_PATH, ORDERING_FLAG, TEST_OUTPUT_PATH};

    // Clear the output directory before running the driver
    clearOutputDirectory();

    // Run the driver
    Driver.main(args);

    // Check if the output file was created
    File outputFile = new File(TEST_OUTPUT_PATH);
    assertTrue(outputFile.exists());

  }

  private void clearOutputDirectory() throws IOException {
    // Delete all files in the output directory
    Path outputDirectory = Path.of(TEST_OUTPUT_PATH);
    Files.walk(outputDirectory)
        .filter(Files::isRegularFile)
        .forEach(file -> {
          try {
            Files.delete(file);
          } catch (IOException e) {
            e.printStackTrace();
          }
        });
  }
}
