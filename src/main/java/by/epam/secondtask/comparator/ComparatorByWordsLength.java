package by.epam.secondtask.comparator;

import by.epam.secondtask.composite.ComponentText;
import by.epam.secondtask.calculate.TextCalculate;

import java.util.Comparator;

public class ComparatorByWordsLength implements Comparator<ComponentText> {

    @Override
    public int compare(ComponentText word1, ComponentText word2) {
        return TextCalculate.calculateWordsLength(word1) - TextCalculate.calculateLexemesLength(word2);
    }
}
