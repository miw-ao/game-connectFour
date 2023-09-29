package connectfour;

public enum Direction {
    HORIZONTAL(Sense.WEST, Sense.EAST),
    VERTICAL(Sense.SOUTH, Sense.NORTH),
    MAIN_DIAGONAL(Sense.SOUTH_EAST, Sense.NORTH_WEST),
    INVERSE_DIAGONAL(Sense.SOUTH_WEST, Sense.NORTH_EAST);

    private final Sense mainSense;
    private final Sense oppositeSense;

    private Sense currentSense;

    Direction(Sense mainSense, Sense oppositeSense) {
        this.mainSense = mainSense;
        this.oppositeSense = oppositeSense;

        this.currentSense = mainSense;
    }

    public Sense getCurrentSense() {
        return this.currentSense;
    }

    public void moveInMainSense() {
        this.currentSense = this.mainSense;
    }

    public void moveInOppositeSense() {
        this.currentSense = this.oppositeSense;
    }
}
