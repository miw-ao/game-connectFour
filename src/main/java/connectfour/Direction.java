package connectfour;

public enum Direction {
    HORIZONTAL(Sense.WEST),
    VERTICAL(Sense.SOUTH),
    MAIN_DIAGONAL(Sense.SOUTH_EAST),
    INVERSE_DIAGONAL(Sense.SOUTH_WEST);

    private Sense sense;

    Direction(Sense sense) {
        this.sense = sense;
    }

    public Sense getSense() {
        return this.sense;
    }

    public void reset() {
        HORIZONTAL.sense = Sense.WEST;
        VERTICAL.sense = Sense.SOUTH;
        MAIN_DIAGONAL.sense = Sense.SOUTH_EAST;
        INVERSE_DIAGONAL.sense = Sense.SOUTH_WEST;
    }

    public void directionToMove() {
        HORIZONTAL.sense = Sense.EAST;
        VERTICAL.sense = Sense.NORTH;
        MAIN_DIAGONAL.sense = Sense.NORTH_WEST;
        INVERSE_DIAGONAL.sense = Sense.NORTH_EAST;
    }

    public void opposite() {
        this.sense = this.sense.getOpposite();
    }

}
