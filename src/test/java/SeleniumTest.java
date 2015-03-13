import edu.emory.mathcs.backport.java.util.Arrays;
import junit.framework.ComparisonFailure;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.IOException;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)

public class SeleniumTest {

@BeforeClass
public static void BeforeClass01() throws Exception {

}

    //Test data generator
    @Parameterized.Parameters(name = "Iteration #{index}: exp:{1};act:{2}")
    public static Collection<String[]> data() throws IOException {
        Selenium selenium = new Selenium();
        return Arrays.asList(selenium.a2d());
    }

    //@Parameter for Field injection instead of Constructor
    @Parameterized.Parameter(value = 0)
    public String test_id;

    @Parameterized.Parameter(value = 1)
    public static String expected_Result;

    @Parameterized.Parameter(value = 2)
    public static String actual_Result;

    @Test
    public void test_Title_Validation() throws ComparisonFailure {
        System.out.println("Test Case: " + test_id + " Expected Result: " + expected_Result + " Actual Result: " + actual_Result);
        assertEquals("FAILED", expected_Result, actual_Result);
    }

}