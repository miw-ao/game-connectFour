package connectfour;

import utils.YesNoDialog;

public class ConnectFour {

    private Board board;
    private Turn turn;

    ConnectFour() {
        this.board = new Board();
        this.turn = new Turn(this.board);
    }

    private void play() {
        do {
            this.playGame();
        } while (this.isResumedGame());
    }

    private void playGame() {
        Message.TITLE.writeln();
        this.board.write();
        do {
            this.turn.play();
            this.board.write();
        } while (!this.isConnectFour());
        this.turn.writeWinner();
    }

    private boolean isConnectFour() {
        return this.board.isConnectFour(this.turn.getActiveColor());
    }

    private boolean isResumedGame() {
        YesNoDialog yesNoDialog = new YesNoDialog();
        yesNoDialog.read(Message.RESUME.toString());
        if (yesNoDialog.isAffirmative()) {
            this.board.reset();
            this.turn.reset();
        }
        return yesNoDialog.isAffirmative();
    }

    public static void main(String[] args) {
        new ConnectFour().play();
    }
}