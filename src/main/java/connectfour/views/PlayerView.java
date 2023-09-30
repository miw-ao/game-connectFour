package connectfour.views;

import connectfour.models.Game;

public class PlayerView {

    private Game game;

    PlayerView(Game game) {
        this.game = game;
    }

    void interact() {
        this.putToken();
    }

    private void putToken() {
        this.game.putToken();
    }

    private void errorPutToken() {
        this.game.errorPutToken();
    }

    //TODO hay que ver como colocar putToken() e inputColumn(), lo comentado es del profe
}
