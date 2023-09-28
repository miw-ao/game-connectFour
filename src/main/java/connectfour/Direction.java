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

    public void opposite() {
        this.sense = this.sense.getOpposite();
    }

}
