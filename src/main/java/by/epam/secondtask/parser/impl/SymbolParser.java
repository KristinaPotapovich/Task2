package by.epam.secondtask.parser.impl;

import by.epam.secondtask.composite.ComponentText;
import by.epam.secondtask.composite.impl.CompositeText;
import by.epam.secondtask.composite.impl.PartText;
import by.epam.secondtask.parser.BaseParser;
import by.epam.secondtask.composite.ComponentPartTextType;

import java.util.regex.Pattern;

public class SymbolParser implements BaseParser {
    private static SymbolParser instance;
    private static final String LETTER = "[a-zA-Zа-яА-Я]";
    private static final String PUNCTUATION = "\\p{Punct}";
    private static final String NUMBER = "[\\d]";

    private SymbolParser() {
    }

    public static SymbolParser getInstance() {
        if (instance == null) {
            instance = new SymbolParser();
        }
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
                PartText partTextPunctual = new PartText(symbol, PartText.Type.PUNCTUATION);
                componentText.add(partTextPunctual);
            } else if (Pattern.matches(NUMBER, symbol.toString())) {
                PartText partText = new PartText(symbol, PartText.Type.NUMBER);
                componentText.add(partText);
            }
        }
        return componentText;
    }
}
