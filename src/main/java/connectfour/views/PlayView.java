package connectfour.views;

import connectfour.models.Game;

class PlayView extends WithGameView {

    PlayView(Game game) {
        super(game);
    }

    void interact() {
        do {
            new PlayerView(this.game).interact();
            new BoardView().write(this.game);
            this.game.next();
        } while (!this.game.isConnectFour() && !this.game.isTied());

        if (this.game.isTied()) {
            Message.PLAYER_TIED.writeln();
        } else {
            Message.PLAYER_WIN.writelnWin(this.game.getActiveColor().toString());
        }
    }

}
