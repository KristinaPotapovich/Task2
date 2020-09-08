package by.epam.secondtask.parser.impl;

import by.epam.secondtask.composite.ComponentText;
import by.epam.secondtask.composite.impl.CompositeText;
import by.epam.secondtask.parser.BaseParser;
import by.epam.secondtask.type.ComponentPartTextType;


public class ParagraphParser implements BaseParser {
    private static final ParagraphParser instance = new ParagraphParser();
    private static final String PARAGRAPH_DELIMITER = "[\n\t]+";
    private final SentenceParser sentenceParser = SentenceParser.getInstance();


    private ParagraphParser() {
    }

    public static ParagraphParser getInstance() {
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
