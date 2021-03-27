package com.km.pja;
import java.util.Random;
import java.util.Scanner;


public class GameSimulator {

    private static final String [] avatars = new String[]{
         "\uD83E\uDDB8\u200D♂️",
            "\uD83E\uDDB9",
            "\uD83D\uDC6E",
            "\uD83D\uDC77",
            "\uD83E\uDDD9",
            "\uD83E\uDDD9\u200D♀️"
    };

    private static final Armour[] armours = new Armour[]{
            new Armour(1, "\uD83D\uDEE1"),
            new Armour(2, "\uD83D\uDDD1"),
            new Armour(3, "fat belly"),
            new Armour(2, "\uD83E\uDE79"),
            new Armour(1, "⚰"),
    };
    private static final Weapon[] weapons = new Weapon[]{
            new Weapon(3, "\uD83D\uDDE1"),
            new Weapon(6, "\uD83D\uDCA3"),
            new Weapon(7, "\uD83D\uDD2B"),
            new Weapon(8, "\uD83D\uDD28"),
            new Weapon(5, "\uD83E\uDE93"),
    };

    private static final Opponent[] opponents = new Opponent[]{
            new Opponent(20, weapons[1], armours[1], "", "\uD83E\uDD84"),
            new Opponent(13, weapons[2], armours[1], "","\uD83D\uDC02"),
            new Opponent(15, weapons[3], armours[2], "","\uD83E\uDD96"),
            new Opponent(17, weapons[2], armours[3], "","\uD83D\uDD77"),
            new Opponent(28, weapons[4], armours[2], "","\uD83E\uDD82"),
            new Opponent(39, weapons[2], armours[1], "","\uD83E\uDD9F"),
    };

    private static final Potion[] potions = new Potion[]{
            new Potion(10, "⚗"),
            new Potion(5, "\uD83E\uDDEA"),
            new Potion(12, "\uD83D\uDECF"),
    };

    private static Player player = new Player(50, weapons[0], armours[1], "Sam","\uD83E\uDDB8");

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true){
            System.out.println("Choose mode: ");
            System.out.println("0:edit character 1:change weapon, 2:change armour, 3:fight, 4:info, 5:potions, 6:quit");
            int mode = scanner.nextInt();
            switch (mode){
                case 0: editCharacter(); break;
                case 1: changeWeapon(); break;
                case 2:  changeArmour(); break;
                case 3: {
                    if(player.getHp() > 0) prepareForFight();
                    else cannotFight();
                } break;
                case 4:
                    System.out.println(player.toString());break;
                case 5: takePotion(); break;
                case 6: return;
            }
        }


    }

    public static void editCharacter(){
        System.out.println("Current info about you: ");
        System.out.println(player.toString());
        System.out.println("0: change name");
        System.out.println("1: change avatar");
        int choice = scanner.nextInt();
        switch (choice){
            case 0: changeName(); break;
            case 1: changeAvatar(); break;
            default: break;
        }

    }

    private static void changeAvatar() {
        System.out.println("Choose an avatar: ");
        for (int i = 0; i < Constants.getAvatars().length; i++) {
            System.out.println(i+ ": " + Constants.getAvatars()[i]);
        }
        int choice = scanner.nextInt();
        if (0 <= choice && choice < Constants.getAvatars().length){
            player.setAvatar(Constants.getAvatars()[choice]);
            System.out.println(player.toString());
        }
    }

    private static void changeName() {
        System.out.println("Input a new name: ");
        String name = scanner.next();
        player.setName(name);
        System.out.println(player.toString());

    }

    private static void fight(int choice){
        Opponent opponent = opponents[choice];
        boolean playerTurn = true;
        int round = 0;

        while (!player.isDead() && !opponent.isDead()){
            if (playerTurn){
                System.out.println("1:attack, 2:retreat (! you'll lose some xp)");
                int decision = scanner.nextInt();
                switch (decision){
                    case 1: {
                        System.out.println("Round: " + round);
                        round++;
                        Random rand = new Random();
                        int hitStrength = rand.nextInt(6);
                        if(opponent.getHit(player.getWeapon().getDamage(), hitStrength)){
                            opponent.printHp();
                        }
                        playerTurn = false;
                    }break;
                    case 2: {
                        int xp = opponent.getPoints()/2;
                        player.setScore(-xp);
                        return;
                    }
                    default: break;
                }
            }
            else{
                Random rand = new Random();
                // random hitStrength
                int hitStrength = rand.nextInt(6);
                if(player.getHit(opponent.getWeapon().getDamage(), hitStrength)){
                    player.printHp();
                }
                playerTurn = true;
            }


        }

        if(player.isDead()){
            System.out.println("You are dead :(");
        }
        else {
            System.out.println("You've defeated a monster :)");
            player.setScore(player.getScore() + opponent.getPoints());
        }

    }

    public static void takePotion(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose potion: ");
        for (int i = 0; i < potions.length; i++) {
            System.out.println(i+ ": " + potions[i].getName());
        }
        int choice = scanner.nextInt();
        if (0 <= choice && choice < potions.length){
            player.takePotion(potions[choice].getHp());
            System.out.println(player.toString());
        }

    }

    public static void changeWeapon(){
        System.out.println("Choose weapon: ");
        for (int i = 0; i < weapons.length; i++) {
            System.out.println(i+ ": " + weapons[i].getName());
        }
        int choice = scanner.nextInt();
        if (0 <= choice && choice < weapons.length){
            player.setWeapon(weapons[choice]);
            System.out.println(player.toString());
        }


    }

    public static void changeArmour(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose armour: ");
        for (int i = 0; i < armours.length; i++) {
            System.out.println(i+ ": " + armours[i].getName());
        }
        int choice = scanner.nextInt();
        if (0 <= choice && choice < armours.length){
            player.setArmour(armours[choice]);
            System.out.println(player.toString());
        }

    }

    public static void prepareForFight(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose opponent: ");
        for (int i = 0; i < opponents.length; i++) {
            if(opponents[i].isDead()){
                System.out.println(Constants.ANSI_WHITE + i+ ": " + opponents[i].getAvatar() + Constants.ANSI_RESET);
            }
            else {
                System.out.println(Constants.ANSI_BLACK + i+ ": " + opponents[i].getAvatar() +  Constants.ANSI_RESET);
            }
        }
        int choice = scanner.nextInt();
        if (0 <= choice && choice < opponents.length){
            if(opponents[choice].isDead()){
                System.out.println("The monster is already defeated ;(");
            }
            else {
                fight(choice);
            }
        }

    }

    public static void cannotFight(){
        System.out.println("Sorry, you are too week to fight");
    }

}
