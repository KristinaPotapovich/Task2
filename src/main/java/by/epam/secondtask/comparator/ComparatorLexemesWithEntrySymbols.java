package by.epam.secondtask.comparator;

import by.epam.secondtask.composite.ComponentText;
import by.epam.secondtask.calculate.TextCalculate;

import java.util.Comparator;

public class ComparatorLexemesWithEntrySymbols implements Comparator<ComponentText> {
    private final char symbol;

    public ComparatorLexemesWithEntrySymbols(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public int compare(ComponentText componentText1, ComponentText componentText2) {
        int differenceOfValues = TextCalculate.calculateLexemesEntrySymbol(componentText1, symbol)
                - TextCalculate.calculateLexemesEntrySymbol(componentText2, symbol);
        if (differenceOfValues == 0) {
            return componentText1.toString().compareTo(componentText2.toString());
        }
        return differenceOfValues;
    }
}
