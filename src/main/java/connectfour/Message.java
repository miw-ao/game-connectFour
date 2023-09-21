package connectfour;

import utils.Console;

enum Message {
    TITLE("--- CONNECT FOUR ---"),
    HORIZONTAL_LINE("-------------------------------"),
    VERTICAL_LINE(" | "),
    ENTER_COLUMN_TO_PUT("[#color] Enter a column to put a token: "),
    PLAYER_WIN("#player player: You win!!! :-)"),
    PLAYER_TIED("You tied!!!"),
    RESUME("Do you want to continue?");

    private final String msg;

    Message(String message) {
        this.msg = message;
    }

    void write() {
        Console.getInstance().write(this.msg);
    }

    void writeln() {
        Console.getInstance().writeln(this.msg);
    }

    void writelnWin(String player) {
        assert this == Message.PLAYER_WIN;

        Console.getInstance().writeln(this.msg.replace("#player", player));
    }

    String messagePlayerColor(Color color) {
        assert this == Message.ENTER_COLUMN_TO_PUT;

        return this.msg.replace("#color", color.name());
    }

    @Override
    public String toString() {
        return msg;
    }
}
