package by.epam.secondtask.composite.impl;

import by.epam.secondtask.composite.ComponentText;
import by.epam.secondtask.composite.ComponentPartTextType;

import java.util.ArrayList;
import java.util.List;

public class CompositeText implements ComponentText {
    private ComponentPartTextType currentType;
    private List<ComponentText> components;

    public CompositeText(ComponentPartTextType componentPartTextType) {
        this.currentType = componentPartTextType;
        this.components = new ArrayList<>();
    }

    @Override
    public void add(ComponentText componentText) {
        components.add(componentText);
    }

    @Override
    public void remove(ComponentText componentText) {
        components.remove(componentText);
    }

    @Override
    public ComponentText getChild(int index) {
        return components.get(index);
    }

    @Override
    public ComponentPartTextType findPartTextType() {
        return currentType;
    }

    @Override
    public List<ComponentText> getComponents() {
        return components;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CompositeText)) return false;

        CompositeText that = (CompositeText) o;

        if (currentType != that.currentType) return false;
        return components != null ? components.equals(that.components) : that.components == null;
    }

    @Override
    public int hashCode() {
        int result = currentType != null ? currentType.hashCode() : 0;
        result = 31 * result + (components != null ? components.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (ComponentText component : components) {
            if (ComponentPartTextType.PARAGRAPH == component.findPartTextType()) {
                builder.append("\n");
            }
            if (ComponentPartTextType.LEXEME == component.findPartTextType()) {
                builder.append(" ");
            }
            builder.append(component);
        }
        return builder.toString();
    }
}
