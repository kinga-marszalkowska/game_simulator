package com.km.pja;

public class Player extends GenericPlayer{
    private int score;

    public Player(int hp, Weapon weapon, Armour armour, String name, String avatar) {
        super(hp, avatar, weapon, armour, name);
        score = 0;
    }

    @Override
    public String messageOnMissed(){
        return Constants.ANSI_RED + "You barely missed a hit!" + Constants.ANSI_RESET;
    }

    public void takePotion(int potionStrength){
        if(super.getHp() + potionStrength > super.getMAX_HP()) {
            super.setHp(super.getMAX_HP());
            System.out.println("Your health is full \uD83D\uDCAA");
        }
        else  super.setHp(super.getHp() + potionStrength);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return super.toString() + "score: " + score;
    }
}
