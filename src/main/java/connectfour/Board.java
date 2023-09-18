package connectfour;

import utils.Console;
import utils.Direction;

import java.util.ArrayList;
import java.util.List;

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
        final int connectFour = 4;

        List<Direction> directions = this.getDirections(color);
        if (directions.size() < connectFour - 1) {
            return false;
        }
        for (int i = 0; i < directions.size() - 2; i++) {
            if(directions.get(i).isNull()){
                continue;
            }
            if (directions.get(i).equals(directions.get(i + 1)) && directions.get(i).equals(directions.get(i + 2))) {
                return true;
            }
        }
        return false;
    }

    private List<Direction> getDirections(Color color) {
        assert !color.isNull();

        List<Direction> directions = new ArrayList<>();
        List<Coordinate> coordinates = this.getCoordinates(color);
        if(!coordinates.isEmpty()){
            for (int i = 0; i < coordinates.size() - 1; i++) {
                directions.add(coordinates.get(i).getDirection(coordinates.get(i + 1)));
            }
        }
        return directions;
    }

    List<Coordinate> getCoordinates(Color color) {
        assert !color.isNull();

        List<Coordinate> coordinates = new ArrayList<>();
        for (int i = 0; i < Coordinate.DIMENSION_ROW; i++) {
            for (int j = 0; j < Coordinate.DIMENSION_COLUMN; j++) {
                if (this.getColor(new Coordinate(i,j)) == color) {
                    coordinates.add(new Coordinate(i, j));
                }
            }
        }
        return coordinates;
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
