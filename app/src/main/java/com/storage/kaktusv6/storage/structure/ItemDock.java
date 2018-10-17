package com.storage.kaktusv6.storage.structure;

public class ItemDock {
    private Item item;
    private double length;
    private TypeLoad typeLoad;
    private String nameBox;

    public ItemDock(Item item, double length, TypeLoad typeLoad, String nameBox) {
        this.item = item;
        this.length = length;
        this.typeLoad = typeLoad;
        this.nameBox = nameBox;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public TypeLoad getTypeLoad() {
        return typeLoad;
    }

    public void setTypeLoad(TypeLoad typeLoad) {
        this.typeLoad = typeLoad;
    }

    public String getNameBox() {
        return nameBox;
    }

    public void setNameBox(String nameBox) {
        this.nameBox = nameBox;
    }
}
