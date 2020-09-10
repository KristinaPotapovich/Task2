package by.epam.secondtask.reader;

import by.epam.secondtask.exception.TextException;
import org.testng.Assert;
import org.testng.annotations.Test;

    public class TextReaderTest extends Assert {
        private TextReader textReader = new TextReader();
        @Test
        public void readTextTestTrue() throws TextException {
            String expected = textReader.readText("init/dataTextTest.txt");
            String actual = textReader.readText("init/dataText.txt");
            assertEquals(actual,expected);
        }
        @Test(expectedExceptions = TextException.class)
        public void trowShapeException() throws TextException {
            textReader.readText("/testfile/dataText.txt");
        }
    }

