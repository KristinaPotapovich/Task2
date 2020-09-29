package by.epam.secondtask.composite.impl;

import by.epam.secondtask.composite.ComponentText;
import by.epam.secondtask.composite.ComponentPartTextType;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;


public class PartText implements ComponentText {
    public enum Type {
        PUNCTUATION, LETTER, NUMBER
    }

    private char component;
    private Type type;
    public static final Logger LOGGER = LogManager.getLogger();

    public PartText(char symbol, Type type) {
        this.component = symbol;
        this.type = type;
    }

    @Override
    public void add(ComponentText componentText) {
        LOGGER.log(Level.ERROR,"Add operation  is not possible");
        throw new UnsupportedOperationException("Add operation is not possible");
    }

    @Override
    public void remove(ComponentText componentText) {
        LOGGER.log(Level.ERROR,"Remove operation is not possible");
        throw new UnsupportedOperationException("Remove operation is not possible");
    }

    @Override
    public ComponentText getChild(int index) {
        LOGGER.log(Level.ERROR,"GetChild operation is not possible");
        throw new UnsupportedOperationException("GetChild operation is not possible");
    }

    @Override
    public ComponentPartTextType findPartTextType() {
        LOGGER.log(Level.ERROR,"FindPartTextType operation is not possible");
        throw new UnsupportedOperationException("FindPartTextType operation is not possible");
    }

    @Override
    public List<ComponentText> getComponents() {
        LOGGER.log(Level.ERROR,"GetComponents operation is not possible");
        throw new UnsupportedOperationException("GetComponents operation is not possible");
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

