package com.km.pja;


public class Armour {
    private int armourClass;
    private String name;

    public int getArmourClass() {
        return armourClass;
    }

    public void setArmourClass(int armourClass) {
        this.armourClass = armourClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Armour(int armourClass, String name) {
        this.armourClass = armourClass;
        this.name = name;
    }

    @Override
    public String toString() {
        return "armour: {" + name + " armour class: " + armourClass + "}";
    }
}
