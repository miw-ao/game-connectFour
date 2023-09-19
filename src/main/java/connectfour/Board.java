package connectfour;

import utils.Console;

public class Board {

    private final Color[][] colors;

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

    void putToken(Coordinate coordinate, Color color) {
        assert !coordinate.isNull();

        this.colors[coordinate.getRow()][coordinate.getColumn()] = color;
    }

    private Color getColor(Coordinate coordinate) {
        assert !coordinate.isNull();

        return this.colors[coordinate.getRow()][coordinate.getColumn()];
    }

    boolean isValidColumn(int column) {
        return column >= 0 && column < Coordinate.DIMENSION_COLUMN;
    }

    int getRemainingColumnSquares(int column) {
        int remainingColumnSquares = Coordinate.DIMENSION_ROW;

        for (int i = Coordinate.DIMENSION_ROW - 1; i >= 0; i--) {
            if (this.colors[i][column] != Color.NULL) {
                remainingColumnSquares--;
            }
        }
        return remainingColumnSquares;
    }

    boolean isConnectFour(Color color) {
        assert !color.isNull();

        return isHorizontal(color) || isVertical(color) || isMainDiagonal(color) || isInverseDiagonal(color);
    }

    private boolean isHorizontal(Color color) {
        Color currentColor;
        for (int row = 0; row < this.colors.length; row++) {
            for (int column = 0; column < this.colors[row].length - 3; column++) {
                currentColor = this.colors[row][column];

                if (currentColor.isNull() || currentColor != color) {
                    continue;
                }

                if (currentColor == this.colors[row][column + 1] &&
                        currentColor == this.colors[row][column + 2] &&
                        currentColor == this.colors[row][column + 3]) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isVertical(Color color) {
        Color currentColor;
        for (int row = 0; row < this.colors.length - 3; row++) {
            for (int column = 0; column < this.colors[row].length; column++) {
                currentColor = this.colors[row][column];

                if (currentColor.isNull() || currentColor != color) {
                    continue;
                }

                if (currentColor == this.colors[row + 1][column] &&
                        currentColor == this.colors[row + 2][column] &&
                        currentColor == this.colors[row + 3][column]) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isMainDiagonal(Color color) {
        Color currentColor;
        for (int row = 0; row < this.colors.length - 3; row++) {
            for (int column = 0; column < this.colors[row].length - 3; column++) {
                currentColor = this.colors[row][column];

                if (currentColor.isNull() || currentColor != color) {
                    continue;
                }

                if (currentColor == this.colors[row + 1][column + 1] &&
                        currentColor == this.colors[row + 2][column + 2] &&
                        currentColor == this.colors[row + 3][column + 3]) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isInverseDiagonal(Color color) {
        Color currentColor;
        for (int row = 0; row < this.colors.length - 3; row++) {
            for (int column = 3; column < this.colors[row].length; column++) {
                currentColor = this.colors[row][column];

                if (currentColor.isNull() || currentColor != color) {
                    continue;
                }

                if (currentColor == this.colors[row + 1][column - 1] &&
                        currentColor == this.colors[row + 2][column - 2] &&
                        currentColor == this.colors[row + 3][column - 3]) {
                    return true;
                }
            }
        }
        return false;
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
