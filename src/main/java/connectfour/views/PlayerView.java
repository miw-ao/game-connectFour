package connectfour.views;

import connectfour.models.Game;
import connectfour.types.Error;
import utils.views.Console;

class PlayerView extends WithGameView {

    PlayerView(Game game) {
        super(game);
    }

    void interact() {
        int column = this.inputColumn();
        this.putToken(column);
    }

    private int inputColumn() {
        int column;
        Console console = Console.getInstance();
        Error error;
        do {
            column = console.readInt(Message.ENTER_COLUMN_TO_PUT.messagePlayerColor(this.game.getActiveColor())) - 1;
            error = getInvalidColumn(column);
        } while (!error.isNull());
        return column;
    }

    private Error getInvalidColumn(int column) {
        Error error = this.game.getInvalidColumn(column);
        new ErrorView().writeln(error);
        return error;
    }

    private void putToken(int column) {
        this.game.putToken(column);
    }

}
