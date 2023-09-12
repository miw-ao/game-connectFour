package connectfour;

import utils.Console;

public class Board {

    private Color[][] colors;

    Board() {
        this.colors = new Color[Coordinate.DIMENSION_ROW][Coordinate.DIMENSION_COLUMN];
        this.reset();
    }

    void reset() {
        for (int i = 0; i < Coordinate.DIMENSION_ROW; i++) {
            for (int j = 0; j < Coordinate.DIMENSION_COLUMN; j++) {
                this.colors[i][j] = Color.NULL;
            }
        }
    }

    private Color getColor(Coordinate coordinate) {
        assert !coordinate.isNull();

        return this.colors[coordinate.getRow()][coordinate.getColumn()];
    }

    void write() {
        Message.HORIZONTAL_LINE.writeln();
        for (int i = 0; i < Coordinate.DIMENSION_ROW; i++) {
            Message.VERTICAL_LINE.write();
            for (int j = 0; j < Coordinate.DIMENSION_COLUMN; j++) {
                this.getColor(new Coordinate(i, j)).write();
                Message.VERTICAL_LINE.write();
            }
            Console.getInstance().writeln();
        }
        Message.HORIZONTAL_LINE.writeln();
    }

}
