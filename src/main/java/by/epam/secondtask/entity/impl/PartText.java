package by.epam.secondtask.entity.impl;

import by.epam.secondtask.entity.ComponentText;
import by.epam.secondtask.type.PartTextType;

public class PartText implements ComponentText {
    private long partTextId;
    private PartTextType partTextType;

    public PartText(long partTextId, PartTextType partTextType) {
        this.partTextId = partTextId;
        this.partTextType = partTextType;
    }

    public long getPartTextId() {
        return partTextId;
    }

    public void setPartTextId(long partTextId) {
        this.partTextId = partTextId;
    }

    public PartTextType getPartTextType() {
        return partTextType;
    }

    public void setPartTextType(PartTextType partTextType) {
        this.partTextType = partTextType;
    }

    @Override
    public void add(ComponentText componentText) {

    }

    @Override
    public void remove(ComponentText componentText) {

    }

    @Override
    public void read(ComponentText componentText) {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PartText)) return false;

        PartText partText = (PartText) o;

        if (getPartTextId() != partText.getPartTextId()) return false;
        return getPartTextType() == partText.getPartTextType();
    }

    @Override
    public int hashCode() {
        int result = (int) (getPartTextId() ^ (getPartTextId() >>> 32));
        result = 31 * result + (getPartTextType() != null ? getPartTextType().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("PartText{").append("partTextId=").append(partTextId)
                .append(", partTextType=").append(partTextType).append('}').toString();
    }
}
