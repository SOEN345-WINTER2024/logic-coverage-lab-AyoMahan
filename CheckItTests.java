import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class CheckItTests {

     //predicate tests, make p=true and p=false

    @Test
    public void predicateTestAPositive() {
        assertTrue("P is true when a is true", checkIt(true, false, false));
        assertTrue("P is true when a is true", checkIt(true, true, false));
        assertTrue("P is true when a is true", checkIt(true, false, true));
        assertTrue("P is true when a is true", checkIt(true, true, true));
    }

    @Test
    public void predicateTestANegative() {
        assertTrue("P is true when b and c are true", checkIt(false, true, true));
        assertFalse("P isn't true when a, b, and c are all false", checkIt(false, false, false));
        assertFalse("P is not true when b is true and c is false", checkIt(false, true, false));
    }


    //clause coverage tests
    @Test
    public void testClauseCoverage() {
        assertTrue("P is true", checkIt(true, true, true));
        assertTrue("P is true", checkIt(true, true, false));
        assertTrue("P is true", checkIt(true, false, true));
        assertTrue("P is true", checkIt(true, false, false));
        assertTrue("P is false", checkIt(false, true, true));
        assertFalse("P is false", checkIt(false, false, false));
        assertFalse("P is false", checkIt(false, false, true));
        assertFalse("P is false", checkIt(false, true, false));
    }


    //cacc coverage
    @Test
    public void caccTestAIsTrue() {
        assertTrue("P is true when a is true", checkIt(true, false, false));
        assertTrue("P is true when a is true", checkIt(true, true, false));
        assertTrue("P is true when a is true", checkIt(true, false, true));
        assertTrue("P is true when a is true", checkIt(true, true, true));
    }

    @Test
    public void caccTestBAndC() {
        assertTrue("P is true when b and c are true", checkIt(false, true, true));
        assertFalse("P isn't true when b is true and c is false", checkIt(false, true, false));
        assertFalse("P isn't true when b and c are false", checkIt(false, false, false));
    }


    //bacc coverage
    @Test
    public void raccTestAIsTrue() {
        assertTrue("P is true when a is true", checkIt(true, true, true));
        assertTrue("P is true when a is true", checkIt(true, true, false));
        assertTrue("P is true when a is true", checkIt(true, false, true));
        assertTrue("P is true when a is true", checkIt(false, true, true));
        assertFalse("P is true when a is true", checkIt(false, true, false));
        assertFalse("P is true when a is true", checkIt(false, false, true));
    }



    // Helper method to call the checkIt function and return its result
    private boolean checkIt(boolean a, boolean b, boolean c) {
        // Redirect System.out to capture output for testing purposes
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        CheckIt.checkIt(a, b, c);

        // Reset System.out
        System.setOut(System.out);

        // Return true if "P is true" is printed, false otherwise
        return outContent.toString().trim().equals("P is true");
    }
}
