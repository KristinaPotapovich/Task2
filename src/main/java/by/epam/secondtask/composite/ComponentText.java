package by.epam.secondtask.composite;

import by.epam.secondtask.type.ComponentPartTextType;

public interface ComponentText {
    void add(ComponentText componentText);

    void remove(ComponentText componentText);

    ComponentText getChild(int index);

    ComponentPartTextType findPartTextType();
}
