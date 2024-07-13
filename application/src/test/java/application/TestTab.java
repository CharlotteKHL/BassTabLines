package application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
      test.createTab("A B - C + A C# - F");
      assertEquals(
          "G|---------|---1-----|\n" +
          "D|-1-----2-|-1-------|\n" +
          "A|---1-----|---------|\n" +
          "E|---------|-------1-|", 
        test.toString(), "Test 2 bars");
    }

    @Test
    void testLongTab() throws InvalidInputException{

      InvalidInputException e = assertThrows(InvalidInputException.class, () -> test.createTab("A A A A A"));
      assertEquals("Your input is invalid, please only use 4 beats per bar", e.getMessage(),
      "Test exception thrown when input is too long");

    }

    @Test
    void testInvalidNote() throws InvalidInputException{
      
      InvalidInputException e = assertThrows(InvalidInputException.class, () -> test.createTab("="));
      assertEquals("An invalid note has been included, please only include: C,C#,D,D#,E,F,F#,G,G#,A,A#,B", e.getMessage(),
      "Test exception thrown when input includes invalid character");

    }

    @Test
    void testEmptyNote() throws InvalidInputException{
      
      InvalidInputException e = assertThrows(InvalidInputException.class, () -> test.createTab("A   B A"));
      assertEquals("An invalid note has been included, please only include: C,C#,D,D#,E,F,F#,G,G#,A,A#,B", e.getMessage(),
      "Test exception thrown when input includes an empty character in the middle");

    }
}
