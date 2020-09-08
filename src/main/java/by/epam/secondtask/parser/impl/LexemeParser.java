package by.epam.secondtask.parser.impl;

import by.epam.secondtask.composite.ComponentText;
import by.epam.secondtask.composite.impl.CompositeText;
import by.epam.secondtask.parser.BaseParser;
import by.epam.secondtask.type.ComponentPartTextType;

public class LexemeParser implements BaseParser {
    private static final LexemeParser instance = new LexemeParser();
    private static final String LEXEME_DELIMITER = "\\s+";
    private final SymbolParser symbolParser = SymbolParser.getInstance();

    private LexemeParser() {
    }
    public static LexemeParser getInstance(){
        return instance;
    }
    @Override
    public ComponentText parse(String sentence) {
        ComponentText componentText = new CompositeText(ComponentPartTextType.SENTENCE);
        String[] lexemes = sentence.split(LEXEME_DELIMITER);
        for (String lexeme : lexemes) {
            ComponentText componentSymbols = symbolParser.parse(lexeme);
            componentText.add(componentSymbols);
        }
        return componentText;
    }
}
