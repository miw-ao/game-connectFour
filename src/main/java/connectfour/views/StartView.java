package connectfour.views;

import connectfour.models.Game;
import utils.views.Message;

public class StartView extends WithGameView {

    StartView(Game game) {
        super(game);
    }

    void interact() {
        Message.TITLE.writeln();
        new BoardView().write(this.game);
    }

}
