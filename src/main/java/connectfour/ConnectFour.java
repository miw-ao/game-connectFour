package connectfour;

public class ConnectFour {

    private Board board;

    ConnectFour() {
        this.board = new Board();
    }

    public static void main(String[] args) {
        new ConnectFour().board.write();
    }
}