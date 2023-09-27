package connectfour;

import java.util.Objects;

class Coordinate {
    private final int row;
    private final int column;

    Coordinate(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return this.row;
    }

    public int getColumn() {
        return this.column;
    }

    public Coordinate nextCoordinate(Direction direction) {
        return new Coordinate(this.getRow() + direction.getRowIncrement(), this.getColumn() + direction.getColumnIncrement());
    }

    public boolean isValid() {
        return this.row >= 0 && this.row < Board.DIMENSION_ROW && this.column >= 0 && this.column < Board.DIMENSION_COLUMN;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return row == that.row && column == that.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }
}