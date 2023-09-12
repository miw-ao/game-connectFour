package connectfour;

import utils.Console;

enum Message {
    TITLE("--- CONNECT FOUR ---"),
    HORIZONTAL_LINE("-------------------------------"),
    VERTICAL_LINE(" | ");

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

    /* void writeln(String player) {
        assert this == Message.PLAYER_WIN;

        Console.getInstance().writeln(this.message.replaceAll("#player", "" + player));
    } */

    @Override
    public String toString() {
        return message;
    }
}
