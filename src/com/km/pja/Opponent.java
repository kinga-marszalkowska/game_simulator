package com.km.pja;

public class Opponent extends GenericPlayer{
    private int points;

    public Opponent(int hp, Weapon weapon, Armour armour, String name, String avatar) {
        super(hp, avatar, weapon, armour, name);
        points = hp;
    }

    @Override
    public String messageOnMissed(){
        return Constants.ANSI_RED + "Monster missed your hit!" + Constants.ANSI_RESET;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
