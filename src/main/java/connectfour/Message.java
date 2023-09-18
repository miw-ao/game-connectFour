package connectfour;

import utils.Console;

enum Message {
    TITLE("--- CONNECT FOUR ---"),
    HORIZONTAL_LINE("-------------------------------"),
    VERTICAL_LINE(" | "),
    ENTER_COLUMN_TO_PUT("[#color] Enter a column to put a token: "),
    PLAYER_WIN("#player player: You win!!! :-)"),
    RESUME("Do you want to continue");

    private String message;

    Message(String message) {
        this.message = message;
    }

    void write() {
        Console.getInstance().write(this.message);
    }

    void writeln() {
        Console.getInstance().writeln(this.message);
    }

    void writelnWin(String player) {
        assert this == Message.PLAYER_WIN;

        Console.getInstance().writeln(this.message.replaceAll("#player", "" + player));
    }

    String messagePlayerColor(Color color) {
        assert this == Message.ENTER_COLUMN_TO_PUT;

        return this.message.replaceAll("#color", "" + color.name());
    }

    @Override
    public String toString() {
        return message;
    }
}
