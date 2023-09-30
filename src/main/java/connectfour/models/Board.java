package connectfour.models;

import connectfour.types.Color;
import connectfour.types.Coordinate;
import utils.models.Direction;

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

    public Color getColor(Coordinate coordinate) {
        return this.colors[coordinate.getRow()][coordinate.getColumn()];
    }

    boolean isValidColumn(int column) {
        return column >= 0 && column < DIMENSION_COLUMN;
    }

    public boolean isValidCoordinate(Coordinate coordinate) {
        return coordinate.getRow() >= 0 && coordinate.getRow() < Board.DIMENSION_ROW && coordinate.getColumn() >= 0 && coordinate.getColumn() < Board.DIMENSION_COLUMN;
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

        if (this.putTokens < (Game.CONNECT_FOUR * 2) - 1) {
            return false;
        }
        List<Line> lines = new ArrayList<>();
        Line line;
        for (Direction direction : Direction.values()) {
            line = new Line(lastCoordinate, direction, this);
            if (line.getCoordinates().size() == Game.CONNECT_FOUR) {
                lines.add(line);
            }
        }
        do {
            if (this.checkLines(lines, color)) {
                return true;
            }
            lines = this.getMovedLines(lines);
        } while (!lines.isEmpty());
        return false;
    }

    private boolean checkLines(List<Line> lines, Color color) {
        for (Line line : lines) {
            if (this.checkLineColor(line, color)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkLineColor(Line line, Color color) {
        int connectedTokens;
        Coordinate checkingCoordinate;
        connectedTokens = 0;
        for (int i = 0; i < Game.CONNECT_FOUR; i++) {
            checkingCoordinate = line.getCoordinates().get(i);
            if (this.colors[checkingCoordinate.getRow()][checkingCoordinate.getColumn()] == color) {
                connectedTokens++;
            }
        }
        return connectedTokens == Game.CONNECT_FOUR;
    }

    private List<Line> getMovedLines(List<Line> lines) {
        List<Line> movedLines = new ArrayList<>();
        for (Line movedLine: lines) {
            if (movedLine.isMovable(this.lastCoordinate, this)) {
                movedLine.move();
                movedLines.add(movedLine);
            }
        }
        return movedLines;
    }

}
