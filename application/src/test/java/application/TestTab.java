package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestTabs{
    private Tab test;

    @BeforeEach
    void initialise(){
      test = new Tab();
    }
    
    @Test
    void testInitialise(){
      assertNotNull(test, "Test class constructor works");
    }

    @Test
    void testPrintEmpty(){
      assertEquals("G|\nD|\nA|\nE|", test.toString(), "Test class print formatting");
    }

    @Test
    void testCreateTabEmpty() throws InvalidInputException{
      test.createTab("- - - -");
      assertEquals("G|---------|\nD|---------|\nA|---------|\nE|---------|", test.toString(),
        "Test input of only dashes (empty notes)");
    }

    @Test
    void testCreateTabEmptyMulti() throws InvalidInputException{
      test.createTab("- - - - + - - - - ");
      assertEquals("G|---------|---------|\nD|---------|---------|\nA|---------|---------|\nE|---------|---------|", 
        test.toString(), "Test multiple empty bar notes");
    }

    @Test
    void testCreateTabEmptyDiff() throws InvalidInputException{
      test.createTab("- - - - + - - - - +");
      assertEquals("G|---------|---------|\nD|---------|---------|\nA|---------|---------|\nE|---------|---------|", 
        test.toString(), "Test multiple empty bar notes with different input");
    }

    @Test
    void testCreateTabAs() throws InvalidInputException{
      test.createTab("A A A A");
      assertEquals("G|---------|\nD|-1-1-1-1-|\nA|---------|\nE|---------|", 
        test.toString(), "Test 1 bar with just A");
    }

    @Test
    void testDiffChords() throws InvalidInputException{
      test.createTab("A B - C + A C# - F +");
      assertEquals(
          "G|---------|---1-----|\n" +
          "D|-1-----2-|-1-------|\n" +
          "A|---1-----|---------|\n" +
          "E|---------|-------1-|", 
        test.toString(), "Test 1 bar with just A");
    }
}
