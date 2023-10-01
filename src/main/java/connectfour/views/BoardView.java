package connectfour.views;

import connectfour.models.Game;
import connectfour.types.Coordinate;
import utils.views.Console;

class BoardView {

    void write(Game game) {
        Message.HORIZONTAL_LINE.writeln();
        for (int i = 0; i < game.getDimensionRowBoard(); i++) {
            Message.VERTICAL_LINE.write();
            for (int j = 0; j < game.getDimensionColumnBoard(); j++) {
                new ColorView().write(game.getColor(new Coordinate(i, j)));
                Message.VERTICAL_LINE.write();
            }
            Console.getInstance().writeln();
        }
        Message.HORIZONTAL_LINE.writeln();
    }

}
