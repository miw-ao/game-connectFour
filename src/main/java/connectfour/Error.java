package connectfour;

import utils.Console;

enum Error {

    WRONG_COLUMN("The column is wrong"),
    FULL_COLUMN("The column is full"),
    NULL;

    private String message;

    Error(){
    }

    Error(String message){
        this.message = message;
    }

    void writeln() {
        if (!this.isNull()) {
            Console.getInstance().writeln(this.message);
        }
    }

    public boolean isNull() {
        return this == Error.NULL;
    }

}
