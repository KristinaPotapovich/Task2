package by.epam.secondtask.parser.impl;

import by.epam.secondtask.composite.ComponentText;
import by.epam.secondtask.composite.impl.CompositeText;
import by.epam.secondtask.composite.impl.PartText;
import by.epam.secondtask.parser.BaseParser;
import by.epam.secondtask.type.ComponentPartTextType;

import java.util.regex.Pattern;

public class SymbolParser implements BaseParser {
    private static final SymbolParser instance = new SymbolParser();
    private static final String LETTER = "[a-zA-Z]";
    private static final String PUNCTUATION = "\\p{Punct}";

    private SymbolParser() {
    }

    public static SymbolParser getInstance() {
        return instance;
    }

    @Override
    public ComponentText parse(String lexeme) {
        ComponentText componentText = new CompositeText(ComponentPartTextType.LEXEME);
        char[] symbols = lexeme.toCharArray();
        for (Character symbol : symbols) {
            if (Pattern.matches(LETTER, symbol.toString())) {
                PartText partTextLetter = new PartText(symbol, PartText.Type.LETTER);
                componentText.add(partTextLetter);
            } else if (Pattern.matches(PUNCTUATION, symbol.toString())) {
                PartText partTextPunct = new PartText(symbol, PartText.Type.PUNCTUATION);
                componentText.add(partTextPunct);
            }
        }
        return componentText;
    }
}