package com.km.pja;



public class Potion {
    private int hp;
    private String name;

    public Potion(int hp, String name) {
        this.hp = hp;
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " hp: " + hp;
    }
}
