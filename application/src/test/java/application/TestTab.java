package application;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TestTabs{
    private Tab test = new Tab();

    @Test
    void testInitialise(){
        assertNotNull(test);
    }

    @Test
    void testPrintEmpty(){
        assertEquals("G|\nD|\nA|\nE|", test.toString());
    }
}
