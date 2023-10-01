package utils;

public enum Direction {
    HORIZONTAL(new Sense[]{Sense.WEST, Sense.EAST}),
    VERTICAL(new Sense[]{Sense.SOUTH, Sense.NORTH}),
    MAIN_DIAGONAL(new Sense[]{Sense.SOUTH_EAST, Sense.NORTH_WEST}),
    INVERSE_DIAGONAL(new Sense[]{Sense.SOUTH_WEST, Sense.NORTH_EAST});

    private final Sense[] senses;
    private Sense currentSense;

    Direction(Sense[] senses) {
        this.senses = senses;
        this.currentSense = this.senses[0];
    }

    public Sense getCurrentSense() {
        return this.currentSense;
    }

    public void moveInMainSense() {
        this.currentSense = this.senses[0];
    }

    public void moveInOppositeSense() {
        this.currentSense = this.senses[1];
    }

}
