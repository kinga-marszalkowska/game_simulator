package com.km.pja;


public class Constants {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    static final Armour[] armours = new Armour[]{
            new Armour(1, "\uD83D\uDEE1"),
            new Armour(2, "\uD83D\uDDD1"),
            new Armour(3, "fat belly"),
            new Armour(2, "\uD83E\uDE79"),
            new Armour(1, "⚰"),
    };
    static final Weapon[] weapons = new Weapon[]{
            new Weapon(3, "\uD83D\uDDE1"),
            new Weapon(6, "\uD83D\uDCA3"),
            new Weapon(7, "\uD83D\uDD2B"),
            new Weapon(8, "\uD83D\uDD28"),
            new Weapon(5, "\uD83E\uDE93"),
    };

    static final Opponent[] opponents = new Opponent[]{
            new Opponent(20, weapons[1], armours[1], "", "\uD83E\uDD84"),
            new Opponent(13, weapons[2], armours[1], "","\uD83D\uDC02"),
            new Opponent(15, weapons[3], armours[2], "","\uD83E\uDD96"),
            new Opponent(17, weapons[2], armours[3], "","\uD83D\uDD77"),
            new Opponent(28, weapons[4], armours[2], "","\uD83E\uDD82"),
            new Opponent(39, weapons[2], armours[1], "","\uD83E\uDD9F"),
    };


    static final Potion[] potions = new Potion[]{
            new Potion(10, "⚗"),
            new Potion(5, "\uD83E\uDDEA"),
            new Potion(12, "\uD83D\uDECF"),
    };

    static final String [] avatars = new String[]{
            "\uD83E\uDDB8\u200D♂️",
            "\uD83E\uDDB9",
            "\uD83D\uDC6E",
            "\uD83D\uDC77",
            "\uD83E\uDDD9",
            "\uD83E\uDDD9\u200D♀️"
    };

}
