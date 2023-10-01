package connectfour;

import connectfour.models.Game;
import connectfour.views.View;

public class ConnectFour {

    private final Game game;
    private final View view;

    ConnectFour() {
        this.game = new Game();
        this.view = new View(this.game);
    }

    public static void main(String[] args) {
        new ConnectFour().play();
    }

    private void play() {
        do {
            this.view.start();
            this.view.play();
        } while (this.view.resume());
    }

}
