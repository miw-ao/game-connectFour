package connectfour.views;

import connectfour.models.Game;

public class PlayerView {

    private final Game game;

    PlayerView(Game game) {
        this.game = game;
    }

    void interact() {
        this.putToken();
    }

    private void putToken() {
        this.game.putToken();
    }

    //TODO hay que ver como colocar putToken() e inputColumn(), hay otro TODO en Player.java
}
