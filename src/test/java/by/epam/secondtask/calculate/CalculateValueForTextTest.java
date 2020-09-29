package by.epam.secondtask.calculate;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CalculateValueForTextTest extends Assert {
    private String formula;

    @BeforeTest
    private void init() {
        formula = "13+(i--)";
    }

    @Test
    public void initValueTestPositive() {
        String expected = "25.0";
        String actual = CalculateValueForText.initValue(formula);
        assertEquals(actual, expected);
    }

    @Test
    public void initValueTestNegative() {
        String expected = "13.0";
        String actual = CalculateValueForText.initValue(formula);
        assertNotEquals(actual, expected);
    }
}
