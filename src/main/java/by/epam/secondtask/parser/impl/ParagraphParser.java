package by.epam.secondtask.parser.impl;

import by.epam.secondtask.composite.ComponentText;
import by.epam.secondtask.composite.impl.CompositeText;
import by.epam.secondtask.parser.BaseParser;
import by.epam.secondtask.type.ComponentPartTextType;


public class ParagraphParser implements BaseParser {
    private static ParagraphParser instance;
    private static final String PARAGRAPH_DELIMITER = "(?m)(?=^\\s{4})";
    private final SentenceParser sentenceParser = SentenceParser.getInstance();


    private ParagraphParser() {
    }

    public static ParagraphParser getInstance() {
        if (instance == null) {
            instance = new ParagraphParser();
        }
        return instance;
    }

    @Override
    public ComponentText parse(String text) {
        ComponentText componentText = new CompositeText(ComponentPartTextType.TEXT);

        String[] paragraphs = text.split(PARAGRAPH_DELIMITER);
        for (String paragraph : paragraphs) {
            ComponentText componentSentence = sentenceParser.parse(paragraph.trim());
            componentText.add(componentSentence);
        }
        return componentText;
    }
}
