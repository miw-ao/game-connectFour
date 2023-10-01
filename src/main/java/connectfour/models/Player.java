package connectfour.models;

import connectfour.types.Color;
import connectfour.types.Coordinate;
import connectfour.types.Error;

class Player {

    private final Color color;
    private final Board board;

    Player(Color color, Board board) {
        assert !color.isNull();
        assert board != null;

        this.color = color;
        this.board = board;
    }

    void putToken(int column) {
        int remainingRowsInColumn = this.board.getRemainingRowsInColumn(column);
        Coordinate coordinate = new Coordinate(remainingRowsInColumn - 1, column);
        this.board.putToken(coordinate, this.color);
    }

    Error getInvalidColumn(int column) {
        if (!this.board.isValidColumn(column)) {
            return Error.WRONG_COLUMN;
        } else if (this.board.isFullColumn(column)) {
            return Error.FULL_COLUMN;
        }
        return Error.NULL;
    }

    Color getColor() {
        return this.color;
    }

}
