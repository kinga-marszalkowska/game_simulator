package com.km.pja;

public class GenericPlayer {
    private int hp;
    private String avatar;
    private Weapon weapon;
    private Armour armour;
    private String name;
    private final int MAX_HP = 50;

    public GenericPlayer(int hp, String avatar, Weapon weapon, Armour armour, String name) {
        this.hp = hp;
        this.avatar = avatar;
        this.weapon = weapon;
        this.armour = armour;
        this.name = name;
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
            System.out.println(messageOnMissed());
            return false;
        }

    }

    public String messageOnMissed(){
        return Constants.ANSI_RED + "Missed!" + Constants.ANSI_RESET;
    }

    public void printHp(){
        System.out.println(Constants.ANSI_RED + avatar + " " + name + ", hp: " + hp + Constants.ANSI_RESET);
    }

    public boolean isDead(){
        return hp == 0;
    }

    public int getMAX_HP() {
        return MAX_HP;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
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

    @Override
    public String toString() {
        return avatar + " " + name + ", hp: " + hp + weapon + armour;
    }
}
