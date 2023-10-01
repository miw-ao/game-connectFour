package connectfour.views;

import connectfour.models.Game;
import connectfour.types.Coordinate;
import utils.views.Console;

import static connectfour.models.Board.DIMENSION_COLUMN;
import static connectfour.models.Board.DIMENSION_ROW;

class BoardView {

    void write(Game game) {
        Message.HORIZONTAL_LINE.writeln();
        for (int i = 0; i < DIMENSION_ROW; i++) {
            Message.VERTICAL_LINE.write();
            for (int j = 0; j < DIMENSION_COLUMN; j++) {
                new ColorView().write(game.getColor(new Coordinate(i, j)));
                Message.VERTICAL_LINE.write();
            }
            Console.getInstance().writeln();
        }
        Message.HORIZONTAL_LINE.writeln();
    }

}
