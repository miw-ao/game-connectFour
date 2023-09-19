package connectfour;

import utils.Console;

class Player {

    private Color color;
    private Board board;
    private int putTokens = 0;

    Player(Color color, Board board) {
        assert !color.isNull();
        assert board != null;

        this.color = color;
        this.board = board;
    }

    public void putToken() {
        int column;
        int remainingColumnSquares;
        boolean error;
        do {
            column = this.inputColumn();
            remainingColumnSquares = this.board.getRemainingColumnSquares(column);
            if (remainingColumnSquares == 0) {
                error = true;
                Error.FULL_COLUMN.writeln();
            } else {
                error = false;
            }
        } while (error);
        Coordinate coordinate = new Coordinate(remainingColumnSquares - 1, column);
        this.board.putToken(coordinate, this.color);
        this.putTokens++;
    }

    int inputColumn(){
        int column;
        Console console = Console.getInstance();
        boolean error;
        do {
            column = console.readInt(Message.ENTER_COLUMN_TO_PUT.messagePlayerColor(this.color)) - 1;
            error = !this.board.isValidColumn(column);
            if (error) {
                Error.WRONG_COLUMN.writeln();
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

    int getPutTokens() {
        return this.putTokens;
    }
}
