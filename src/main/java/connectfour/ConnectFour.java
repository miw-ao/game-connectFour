package connectfour;

import utils.YesNoDialog;

class ConnectFour {

    public static final int CONNECT_FOUR = 4;
    private final Board board;
    private final Turn turn;

    ConnectFour() {
        this.board = new Board();
        this.turn = new Turn(this.board);
    }

    public static void main(String[] args) {
        new ConnectFour().runGame();
    }

    private void runGame() {
        do {
            Message.TITLE.writeln();
            this.board.write();
            this.play();
        } while (this.isResumedGame());
    }

    private void play() {
        do {
            this.turn.play();
            this.board.write();
        } while (!this.isConnectFour() && !this.isTied());

        if (this.board.isTied()) {
            Message.PLAYER_TIED.writeln();
        } else {
            this.turn.writeWinner();
        }
    }

    private boolean isConnectFour() {
        return this.board.isConnectFour(this.turn.getActiveColor());
    }

    private boolean isTied() {
        return this.board.isTied();
    }

    private boolean isResumedGame() {
        YesNoDialog yesNoDialog = new YesNoDialog();
        yesNoDialog.read(Message.RESUME.toString());
        if (yesNoDialog.isAffirmative()) {
            this.board.reset();
            this.turn.reset();
            return true;
        }
        return false;
    }

}