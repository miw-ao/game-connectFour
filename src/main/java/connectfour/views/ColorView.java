package connectfour.views;

import connectfour.types.Color;
import utils.views.Console;

class ColorView {

    void write(Color color) {
        String colorName = switch (color.ordinal()) {
            case 0 -> "Y";
            case 1 -> "R";
            default -> " ";
        };
        Console.getInstance().write(colorName);
    }

}
