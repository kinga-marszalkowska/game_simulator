package com.km.pja;



public class Opponent {
    private int hp;
    private Weapon weapon;
    private Armour armour;
    private String name;
    private int points;

    public Opponent(int hp, Weapon weapon, Armour armour, String name) {
        this.hp = hp;
        this.weapon = weapon;
        this.armour = armour;
        this.name = name;
        this.points = hp;
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
            System.out.println(Constants.ANSI_RED + "Monster missed your hit!" + Constants.ANSI_RESET);
            return false;
        }

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

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
    public void printHp(){
        System.out.println(Constants.ANSI_RED + name + ", hp: " + hp + Constants.ANSI_RESET);
    }

    @Override
    public String toString() {
        return "Opponent " + name + ", " +
                "hp: " + hp +
                " xp: " + points +
                ", " + weapon +
                ", " + armour;
    }
}
