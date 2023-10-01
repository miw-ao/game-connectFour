package utils;

public enum Sense {
    NORTH(-1, 0),
    SOUTH(1, 0),
    EAST(0, 1),
    WEST(0, -1),
    NORTH_WEST(-1, -1),
    SOUTH_EAST(1, 1),
    NORTH_EAST(-1, 1),
    SOUTH_WEST(1, -1);

    private final int rowIncrement;
    private final int columnIncrement;

    Sense(int rowIncrement, int columnIncrement) {
        this.rowIncrement = rowIncrement;
        this.columnIncrement = columnIncrement;
    }

    public int getRowIncrement() {
        return this.rowIncrement;
    }

    public int getColumnIncrement() {
        return this.columnIncrement;
    }

}
