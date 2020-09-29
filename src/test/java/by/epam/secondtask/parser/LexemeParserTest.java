package by.epam.secondtask.parser;

import by.epam.secondtask.composite.ComponentText;
import by.epam.secondtask.exception.TextException;
import by.epam.secondtask.parser.impl.LexemeParser;
import by.epam.secondtask.reader.TextReader;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LexemeParserTest extends Assert {
    private LexemeParser lexemeParser;
    private String text;
    private String textTest;
    private String wrongTest;

    @BeforeTest
    private void init() throws TextException {
        lexemeParser = LexemeParser.getInstance();
        TextReader textReader = new TextReader();
        text = textReader.readText("init/dataText.txt");
        textTest = textReader.readText("init/dataTextTest.txt");
        wrongTest = "It has survived - not only (five) centuries, but also the leap into 13+(i--)";
    }

    @Test
    public void parseTestPositive() {
        ComponentText expected = lexemeParser.parse(textTest);
        ComponentText actual = lexemeParser.parse(text);
        assertEquals(actual, expected);
    }

    @Test
    public void parseTestNegative() {
        ComponentText expected = lexemeParser.parse(wrongTest);
        ComponentText actual = lexemeParser.parse(text);
        assertNotEquals(actual, expected);
    }
}
