package connectfour.views;

import connectfour.models.Game;
import utils.views.Message;

class PlayView extends WithGameView {

    PlayView(Game game) {
        super(game);
    }

    void interact() {
        do {
            new PlayerView(this.game).interact();
            this.game.next();
            new BoardView().write(this.game);
        } while (!this.game.isConnectFour());
        Message.PLAYER_WIN.writeln();
    }

}
