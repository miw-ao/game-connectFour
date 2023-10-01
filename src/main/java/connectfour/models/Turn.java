package connectfour.models;

import connectfour.types.Color;
import connectfour.types.Error;

class Turn {

    static final int NUMBER_PLAYERS = 2;
    private final Board board;
    private final Player[] players;
    private int activePlayer;

    Turn(Board board) {
        assert board != null;

        this.board = board;
        this.players = new Player[Turn.NUMBER_PLAYERS];
        this.reset();
    }

    void reset() {
        for (int i = 0; i < NUMBER_PLAYERS; i++) {
            this.players[i] = new Player(Color.getOrdinal(i), this.board);
        }
        this.activePlayer = 0;
    }

    void next() {
        if (!this.board.isConnectFour(this.getActiveColor())) {
            this.activePlayer = (this.activePlayer + 1) % Turn.NUMBER_PLAYERS;
        }
    }

    Color getActiveColor() {
        return this.getActivePlayer().getColor();
    }

    Player getActivePlayer() {
        return this.players[this.activePlayer];
    }

    void putToken(int column) {
        this.getActivePlayer().putToken(column);
    }

    Error getInvalidColumn(int column) {
        return this.getActivePlayer().getInvalidColumn(column);
    }
}
