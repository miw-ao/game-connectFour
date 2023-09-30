package connectfour.models;

import connectfour.types.Color;
import connectfour.types.Coordinate;
import connectfour.views.Message;
import utils.views.Console;

class Player {

    private final Color color;
    private final Board board;

    Player(Color color, Board board) {
        assert !color.isNull();
        assert board != null;

        this.color = color;
        this.board = board;
    }

    //TODO revisar estos 2 métodos, las líneas comentadas ya que debe haber una forma de llamarlas desde el View en vez del Modelo. Así está mal.
    public void putToken() {
        int column;
        int remainingRowsInColumn;
        boolean error;
        do {
            column = this.inputColumn();
            remainingRowsInColumn = this.board.getRemainingRowsInColumn(column);
            //                Error.FULL_COLUMN.writeln();
            error = remainingRowsInColumn == 0;
        } while (error);
        Coordinate coordinate = new Coordinate(remainingRowsInColumn - 1, column);
        this.board.putToken(coordinate, this.color);
    }

    int inputColumn() {
        int column;
        Console console = Console.getInstance();
        boolean error;
        do {
            column = console.readInt(Message.ENTER_COLUMN_TO_PUT.messagePlayerColor(this.color)) - 1;
            error = !this.board.isValidColumn(column);
            if (error) {
//                Error.WRONG_COLUMN.writeln();
            }
        } while (error);
        return column;
    }

    void writeWinner() {
        Message.PLAYER_WIN.writelnWin(this.color.name());
    }

    Color getColor() {
        return this.color;
    }

}
