package cs3500.pa01;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class ReadFileTest {

  /**
   * tests the readFromFiles class
   */
  @Test
  public void testReadFromArrays() {
    ReadFile rf= new ReadFile();
    ArrayList<File> file = new ArrayList<>();
    file.add(new File("sampleinput/arrays.md"));
    rf.readFromFile(file);
    assertEquals("\n" +"# Java Arrays\n" +
        "- An **array** is a collection of variables of the same type\n" +
        "\n" +
        "## Declaring an Array\n" +
        "- General Form: type[] arrayName;\n" +
        "- only creates a reference\n" +
        "\n" +
        "## Creating an Array (Instantiation)\n" +
        "- General form:  arrayName = new type[numberOfElements];\n" +
        "- numberOfElements must be a positive Integer.\n" +
        "- Gotcha: Array size is not  modifiable once instantiated."+"\n", rf.readFromFile(file));
  }

  @Test
  public void testReadFromInvalid() {
    ReadFile rf= new ReadFile();
    ArrayList<File> file = new ArrayList<>();
    assertEquals("", rf.readFromFile(file));
  }

  @Test
  public void testReadFromFiles() {
    ReadFile rf= new ReadFile();
    ArrayList<File> file = new ArrayList<>();
    file.add(new File("sampleinput/arrays.md"));
    file.add(new File("sampleinput/vectors.md"));
    rf.readFromFile(file);
    assertEquals("\n"+"# Java Arrays\n" +
        "- An **array** is a collection of variables of the same type\n" +
        "\n" +
        "## Declaring an Array\n" +
        "- General Form: type[] arrayName;\n" +
        "- only creates a reference\n" +
        "\n" +
        "## Creating an Array (Instantiation)\n" +
        "- General form:  arrayName = new type[numberOfElements];\n" +
        "- numberOfElements must be a positive Integer.\n" +
        "- Gotcha: Array size is not  modifiable once instantiated.\n" +
        "\n" +
        "# Vectors\n" +
        "- Vectors act like resizable arrays\n" +
        "\n" +
        "## Declaring a vector\n" +
        "- General Form: Vector<type> v = new Vector();\n" +
        "- type needs to be a valid reference type\n" +
        "\n" +
        "## Adding an element to a vector\n" +
        "- v.add(object of type);"+"\n", rf.readFromFile(file));
  }

}