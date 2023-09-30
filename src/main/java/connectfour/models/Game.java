package connectfour.models;

import connectfour.types.Color;
import connectfour.types.Coordinate;
import utils.views.Message;
import utils.views.YesNoDialog;

public class Game {

    public static final int CONNECT_FOUR = 4;
    private final Board board;
    private final Turn turn;

    public Game() {
        this.board = new Board();
        this.turn = new Turn(this.board);
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

    public Color getColor(Coordinate coordinate) {
        return this.board.getColor(coordinate);
    }

    public void putToken() {
        this.turn.putToken();
    }

    public void errorPutToken() {
        this.turn.errorPutToken();
    }

    //TODO revisar como se arranca el juego ahora, ya que no se puede imprimir el tablero en el modelo, tiene que hacerlo una vista.

    private void runGame() {
        do {
            Message.TITLE.writeln();
            this.board.write();
            this.play();
        } while (this.isResumedGame());
    }


    private void play() {
        do {
            this.next();
            this.board.write();
        } while (!this.isConnectFour() && !this.isTied());

        if (this.board.isTied()) {
            Message.PLAYER_TIED.writeln();
        } else {
            this.turn.writeWinner();
        }
    }
    private boolean isTied() {
        return this.board.isTied();
    }


    private boolean isResumedGame() {
        YesNoDialog yesNoDialog = new YesNoDialog();
        yesNoDialog.read(Message.RESUME.toString());
        if (yesNoDialog.isAffirmative()) {
            this.reset();
            return true;
        }
        return false;
    }

}