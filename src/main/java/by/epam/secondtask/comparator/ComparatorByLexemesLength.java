package by.epam.secondtask.comparator;

import by.epam.secondtask.composite.ComponentText;
import by.epam.secondtask.calculate.TextCalculate;

import java.util.Comparator;

public class ComparatorByLexemesLength implements Comparator<ComponentText> {
    @Override
    public int compare(ComponentText lexeme1, ComponentText lexeme2) {
        return TextCalculate.calculateLexemesLength(lexeme1) - TextCalculate.calculateLexemesLength(lexeme2);
    }
}
