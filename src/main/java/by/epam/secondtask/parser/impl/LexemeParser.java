package by.epam.secondtask.parser.impl;

import by.epam.secondtask.calculate.CalculateValueForText;
import by.epam.secondtask.composite.ComponentText;
import by.epam.secondtask.composite.impl.CompositeText;
import by.epam.secondtask.parser.BaseParser;
import by.epam.secondtask.composite.ComponentPartTextType;

public class LexemeParser implements BaseParser {
    private static LexemeParser instance;
    private static final String LEXEME_DELIMITER = "\\s+";
    private static final String LEXEME_FORMULA = "[\\d(][\\d\\W)ij(]+";
    private final SymbolParser symbolParser = SymbolParser.getInstance();

    private LexemeParser() {
    }

    public static LexemeParser getInstance() {
        if (instance == null) {
            instance = new LexemeParser();
        }
        return instance;
    }

    @Override
    public ComponentText parse(String sentence) {
        ComponentText componentText = new CompositeText(ComponentPartTextType.SENTENCE);
        String[] lexemes = sentence.split(LEXEME_DELIMITER);
        for (String lexeme : lexemes) {
            if (lexeme.matches(LEXEME_FORMULA)) {
                lexeme = lexeme.replaceAll(LEXEME_FORMULA, CalculateValueForText.initValue(lexeme));
            }
            ComponentText componentSymbols = symbolParser.parse(lexeme);
            componentText.add(componentSymbols);
        }
        return componentText;
    }
}
