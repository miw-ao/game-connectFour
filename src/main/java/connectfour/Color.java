package connectfour;

import utils.Console;

enum Color {

    YELLOW,
    RED,
    NULL;

    static Color getOrdinal(int ordinal) {
        assert ordinal >= 0 && ordinal < Color.NULL.ordinal();

        return Color.values()[ordinal];
    }

    void write() {
        String colorName;
        switch (this) {
            case YELLOW:
                colorName = "Y";
                break;
            case RED:
                colorName = "R";
                break;
            default:
                colorName = " ";
                break;
        }
        Console.getInstance().write(colorName);
    }

    boolean isNull() {
        return this == Color.NULL;
    }

}
