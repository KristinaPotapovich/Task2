package by.epam.secondtask.parser;

import by.epam.secondtask.composite.ComponentText;
import by.epam.secondtask.exception.TextException;
import by.epam.secondtask.parser.impl.ParagraphParser;
import by.epam.secondtask.reader.TextReader;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ParagraphParserTest extends Assert {
    private ParagraphParser paragraphParser;
    private String text;
    private String textTest;
    private String wrongTest;

    @BeforeTest
    private void init() throws TextException {
        paragraphParser = ParagraphParser.getInstance();
        TextReader textReader = new TextReader();
        text = textReader.readText("init/dataText.txt");
        textTest = textReader.readText("init/dataTextTest.txt");
        wrongTest = "It has survived - not only (five) centuries, but also the leap into 13+(i--)";
    }

    @Test
    public void parseTestPositive() {
        ComponentText expected = paragraphParser.parse(textTest);
        ComponentText actual = paragraphParser.parse(text);
        assertEquals(actual, expected);
    }

    @Test
    public void parseTestNegative() {
        ComponentText expected = paragraphParser.parse(wrongTest);
        ComponentText actual = paragraphParser.parse(text);
        assertNotEquals(actual, expected);
    }
}

