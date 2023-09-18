package connectfour;

import utils.SquareBoundedCoordinate;

class Coordinate extends SquareBoundedCoordinate {

    public static final int DIMENSION_ROW = 6;
    public static final int DIMENSION_COLUMN = 7;

    Coordinate() {
        super();
    }

    Coordinate(int row, int column) {
        super(row, column);
    }

    @Override
    protected int getDimensionRow() {
        return Coordinate.DIMENSION_ROW;
    }

    @Override
    protected int getDimensionColumn() {
        return Coordinate.DIMENSION_COLUMN;
    }

}