package by.epam.secondtask.comparator;

import by.epam.secondtask.composite.ComponentText;

import java.util.Comparator;

public class ComparatorParagraphBySentence implements Comparator<ComponentText> {

    @Override
    public int compare(ComponentText paragraph1, ComponentText paragraph2) {
        return Integer.compare(paragraph1.getComponents().size(), paragraph2.getComponents().size());
    }
}
