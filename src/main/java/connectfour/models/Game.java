package connectfour.models;

import connectfour.types.Color;
import connectfour.types.Coordinate;
import connectfour.types.Error;

public class Game {

    public static final int CONNECT_FOUR = 4;
    private final Board board;
    private final Turn turn;

    public Game() {
        this.board = new Board();
        this.turn = new Turn(this.board);
    }

    public int getDimensionRowBoard() {
        return this.board.getDimensionRow();
    }

    public int getDimensionColumnBoard() {
        return this.board.getDimensionColumn();
    }

    public void reset() {
        this.board.reset();
        this.turn.reset();
    }

    public void next() {
        this.turn.next();
    }

    public Color getActiveColor() {
        return this.turn.getActiveColor();
    }

    public boolean isConnectFour() {
        return this.board.isConnectFour(this.turn.getActiveColor());
    }

    public boolean isTied() {
        return this.board.isTied();
    }

    public Color getColor(Coordinate coordinate) {
        return this.board.getColor(coordinate);
    }

    public void putToken(int column) {
        this.turn.putToken(column);
    }

    public Error getInvalidColumn(int column) {
        return this.turn.getInvalidColumn(column);
    }
}