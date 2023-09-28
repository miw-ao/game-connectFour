package connectfour;

import utils.Console;

import java.util.ArrayList;
import java.util.List;

public class Board {

    public static final int DIMENSION_ROW = 6;
    public static final int DIMENSION_COLUMN = 7;
    private final Color[][] colors;
    private int putTokens;
    private Coordinate lastCoordinate;

    Board() {
        this.colors = new Color[DIMENSION_ROW][DIMENSION_COLUMN];
        this.reset();
    }

    void reset() {
        this.putTokens = 0;
        for (int i = 0; i < DIMENSION_ROW; i++) {
            for (int j = 0; j < DIMENSION_COLUMN; j++) {
                this.colors[i][j] = Color.NULL;
            }
        }
    }

    void putToken(Coordinate coordinate, Color color) {
        assert !color.isNull();

        this.colors[coordinate.getRow()][coordinate.getColumn()] = color;
        this.putTokens++;
        this.lastCoordinate = coordinate;
    }

    private Color getColor(Coordinate coordinate) {
        return this.colors[coordinate.getRow()][coordinate.getColumn()];
    }

    boolean isValidColumn(int column) {
        return column >= 0 && column < DIMENSION_COLUMN;
    }

    int getRemainingRowsInColumn(int column) {
        int remainingRowsInColumn = DIMENSION_ROW;

        for (int i = DIMENSION_ROW - 1; i >= 0; i--) {
            if (this.colors[i][column] != Color.NULL) {
                remainingRowsInColumn--;
            }
        }
        return remainingRowsInColumn;
    }

    boolean isTied() {
        return this.putTokens == DIMENSION_ROW * DIMENSION_COLUMN;
    }

    boolean isConnectFour(Color color) {
        assert !color.isNull();

        if (this.putTokens < (ConnectFour.CONNECT_FOUR * 2) - 1) {
            return false;
        }

        List<Line> initialLines = new ArrayList<>();
        Line line;
        for (Direction direction : Direction.values()) {
            line = new Line(lastCoordinate, direction);
            if (line.getCoordinates().size() == 4) {
                initialLines.add(line);
            }
        }

        return checkLines(initialLines, color);
    }

    private boolean checkLines(List<Line> initialLines, Color color) {
        // TODO: Mirar si hay una mejor forma de hacerlo, para que no se repita ese if. A lo mejor comprobando
        // primero en la funcion de arriba las iniciales y luego moverlas, do while, no se...
        for (Line line : initialLines) {
            if (this.checkLineColor(line, color)) {
                return true;
            }
            while (line.isMoveable()) {
                line.move();
                if (this.checkLineColor(line, color)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean checkLineColor(Line line, Color color) {
        int connectedTokens;
        Coordinate checkingCoordinate;
        connectedTokens = 0;
        for (int i = 0; i < ConnectFour.CONNECT_FOUR; i++) {
            checkingCoordinate = line.getCoordinates().get(i);
            if (this.colors[checkingCoordinate.getRow()][checkingCoordinate.getColumn()] == color) {
                connectedTokens++;
            }
        }

        return connectedTokens == ConnectFour.CONNECT_FOUR;
    }

    void write() {
        Message.HORIZONTAL_LINE.writeln();
        for (int i = 0; i < DIMENSION_ROW; i++) {
            Message.VERTICAL_LINE.write();
            for (int j = 0; j < DIMENSION_COLUMN; j++) {
                this.getColor(new Coordinate(i, j)).write();
                Message.VERTICAL_LINE.write();
            }
            Console.getInstance().writeln();
        }
        Message.HORIZONTAL_LINE.writeln();
    }

}
