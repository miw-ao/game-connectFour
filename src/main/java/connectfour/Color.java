package connectfour;

import utils.Console;

enum Color {

    YELLOW,
    RED,
    NULL;

    static Color get(int ordinal){
        assert ordinal >= 0 && ordinal < Color.NULL.ordinal();

        return Color.values()[ordinal];
    }

    void write() {
        String colorName;
        if (this.isYellow()) {
            colorName = "Y";
        } else if (this.isRed()) {
            colorName = "R";
        } else {
            colorName = " ";
        }
        Console.getInstance().write(colorName);
    }

    boolean isNull() {
        return this == Color.NULL;
    }

    boolean isYellow() {
        return this == Color.YELLOW;
    }

    boolean isRed() {
        return this == Color.RED;
    }
}
