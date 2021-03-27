package com.km.pja;


import java.util.Random;

public class Player3 {
    private int hp;
    private String avatar;
    private Weapon weapon;
    private Armour armour;
    private String name;
    private int score;
    private final int MAX_HP = 50;

    public Player3(int hp, Weapon weapon, Armour armour, String name, String avatar) {
        this.hp = hp;
        this.weapon = weapon;
        this.armour = armour;
        this.name = name;
        this.score = 0;
        this.avatar = avatar;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean getHit(int hits, int hitStrength){
        if (hitStrength >= armour.getArmourClass()){
            if(hits > hp){
                hp = 0;
            }
            else {
                hp -= hits;
            }
            return true;
        }
        else {
            System.out.println(Constants.ANSI_RED + "You missed a hit by a whisker!" + Constants.ANSI_RESET);
            return false;
        }

    }

    public void takePotion(int potionStrength){
        if(hp + potionStrength > MAX_HP) {
            hp = MAX_HP;
            System.out.println("Your health is full \uD83D\uDCAA");
        }
        else hp += potionStrength;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armour getArmour() {
        return armour;
    }

    public void setArmour(Armour armour) {
        this.armour = armour;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDead(){
        return hp == 0;
    }


    public void printHp(){
        System.out.println(Constants.ANSI_RED + name + ", hp: " + hp + Constants.ANSI_RESET);
    }
    @Override
    public String toString() {
        return "Player " + avatar + name +
                ", hp: " + hp +
                ", xp: " + score +
                ", " + weapon +
                ", " + armour;
    }
}
