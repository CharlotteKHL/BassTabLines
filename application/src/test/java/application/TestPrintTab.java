package application;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestPrintTab {

    PrintTab test;
    
    @BeforeEach
    void initialise(){
      test = new PrintTab();
    }

    @Test
    void testInitialise(){
      assertNotNull(test, "Test class constructor works");
    }
    
}
