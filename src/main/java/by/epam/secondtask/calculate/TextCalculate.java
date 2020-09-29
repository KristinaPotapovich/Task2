package by.epam.secondtask.calculate;

import by.epam.secondtask.composite.ComponentText;
import by.epam.secondtask.composite.impl.PartText;

import java.util.List;


public class TextCalculate {
    private TextCalculate() {
    }

    public static int calculateLexemesLength(ComponentText sentence) {
        int sum = 0;
        List<ComponentText> lexemes = sentence.getComponents();
        for (ComponentText lexeme : lexemes) {
            sum += lexeme.toString().length();
        }
        return sum;
    }

    public static int calculateWordsLength(ComponentText sentence) {
        int sum = 0;
        List<ComponentText> lexemes = sentence.getComponents();
        for (ComponentText lexeme : lexemes) {
            List<ComponentText> symbols = lexeme.getComponents();
            for (ComponentText symbol : symbols) {
                if ((symbol.findPartTextType().equals(PartText.Type.LETTER)
                        || symbol.findPartTextType().equals(PartText.Type.NUMBER))) {
                    sum++;
                }
            }
        }
        return sum;
    }

    public static int calculateLexemesEntrySymbol(ComponentText lexeme, char symbol) {
        List<ComponentText> symbols = lexeme.getComponents();
        int counter = 0;
        for (ComponentText component : symbols) {
            if (Character.toString(symbol).equals(component.toString())) {
                counter++;
            }
        }
        return counter;
    }
}

