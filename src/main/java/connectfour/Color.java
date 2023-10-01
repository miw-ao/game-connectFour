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
        String colorName = switch (this) {
            case YELLOW -> "Y";
            case RED -> "R";
            default -> " ";
        };
        Console.getInstance().write(colorName);
    }

    boolean isNull() {
        return this == Color.NULL;
    }

}
