package by.epam.secondtask.composite.impl;

import by.epam.secondtask.composite.ComponentText;
import by.epam.secondtask.type.ComponentPartTextType;


public class PartText implements ComponentText {
    public enum Type {
        PUNCTUATION, LETTER, NUMBER
    }

    private char component;
    private Type type;

    public PartText(char symbol, Type type) {
        this.component = symbol;
        this.type = type;
    }

    @Override
    public void add(ComponentText componentText) {

    }

    @Override
    public void remove(ComponentText componentText) {

    }

    @Override
    public ComponentText getChild(int index) {
        return null;
    }

    @Override
    public ComponentPartTextType findPartTextType() {
        return null;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PartText)) return false;

        PartText partText = (PartText) o;

        if (component != partText.component) return false;
        return type == partText.type;
    }

    @Override
    public int hashCode() {
        int result = component;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return Character.toString(component);
    }
}

