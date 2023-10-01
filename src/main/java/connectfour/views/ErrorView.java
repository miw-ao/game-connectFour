package connectfour.views;

import connectfour.types.Error;
import utils.views.Console;

class ErrorView {

    static final String[] MESSAGES = {
            "The column is wrong",
            "The column is full"
    };

    void writeln(Error error) {
        if (!error.isNull()) {
            Console.getInstance().writeln(ErrorView.MESSAGES[error.ordinal()]);
        }
    }

}
