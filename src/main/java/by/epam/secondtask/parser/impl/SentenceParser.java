package by.epam.secondtask.parser.impl;

import by.epam.secondtask.composite.ComponentText;
import by.epam.secondtask.composite.impl.CompositeText;
import by.epam.secondtask.parser.BaseParser;
import by.epam.secondtask.type.ComponentPartTextType;

public class SentenceParser implements BaseParser {
    private static final SentenceParser instance = new SentenceParser();
    private static final String SENTENCE_DELIMITER = "\\[.?!...][^.?!...]+";
    private final LexemeParser lexemeParser = LexemeParser.getInstance();

    private SentenceParser() {
    }

    public static SentenceParser getInstance() {
        return instance;
    }

    @Override
    public ComponentText parse(String paragraph) {
        ComponentText componentText = new CompositeText(ComponentPartTextType.PARAGRAPH);
        String[] sentences = paragraph.split(SENTENCE_DELIMITER);
        for (String sentence : sentences) {
            ComponentText componentLexemes = lexemeParser.parse(sentence.trim());
            componentText.add(componentLexemes);
        }
        return componentText;
    }
}

