package by.epam.secondtask.entity.impl;

import by.epam.secondtask.entity.ComponentText;

import java.util.ArrayList;
import java.util.List;

public class CompositeText implements ComponentText {
    private List<ComponentText> textComponent = new ArrayList<>();
    private long compositeTextId;

    public CompositeText(List<ComponentText> textComponent, long compositeTextId) {
        this.textComponent = textComponent;
        this.compositeTextId = compositeTextId;
    }

    public List<ComponentText> getTextComponent() {
        return textComponent;
    }

    public void setTextComponent(List<ComponentText> textComponent) {
        this.textComponent = textComponent;
    }

    public long getCompositeTextId() {
        return compositeTextId;
    }

    public void setCompositeTextId(long compositeTextId) {
        this.compositeTextId = compositeTextId;
    }

    @Override
    public void add(ComponentText componentText) {
        textComponent.add(componentText);

    }

    @Override
    public void remove(ComponentText componentText) {
        textComponent.remove(componentText);
    }

    @Override
    public void read(ComponentText componentText) {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CompositeText)) return false;

        CompositeText that = (CompositeText) o;

        if (getCompositeTextId() != that.getCompositeTextId()) return false;
        return getTextComponent() != null ? getTextComponent().equals(that.getTextComponent()) : that.getTextComponent() == null;
    }

    @Override
    public int hashCode() {
        int result = getTextComponent() != null ? getTextComponent().hashCode() : 0;
        result = 31 * result + (int) (getCompositeTextId() ^ (getCompositeTextId() >>> 32));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("CompositeText{").append("textComponent=").append(textComponent)
                .append(", compositeTextId=").append(compositeTextId).append('}').toString();
    }
}
