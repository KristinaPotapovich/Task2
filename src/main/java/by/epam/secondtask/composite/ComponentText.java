package by.epam.secondtask.composite;


import java.util.List;

public interface ComponentText {
    void add(ComponentText componentText);

    void remove(ComponentText componentText);

    ComponentText getChild(int index);

    ComponentPartTextType findPartTextType();

    List<ComponentText> getComponents();
}
