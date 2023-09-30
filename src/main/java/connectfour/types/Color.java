package connectfour.types;

import utils.views.Console;

public enum Color {

    YELLOW,
    RED,
    NULL;

    public static Color getOrdinal(int ordinal) {
        assert ordinal >= 0 && ordinal < Color.NULL.ordinal();

        return Color.values()[ordinal];
    }

    public boolean isNull() {
        return this == Color.NULL;
    }

}
