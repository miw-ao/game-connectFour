package utils;

import java.util.Random;

public abstract class SquareBoundedCoordinate {

    private Coordinate adaptee;

    public SquareBoundedCoordinate() {
        this.adaptee = NullCoordinate.getInstance();
    }

    public boolean isNull() {
        return this.adaptee.isNull();
    }

    public SquareBoundedCoordinate(int row, int column) {
        this.adaptee = new ConcreteCoordinate(row, column);

        assert this.isValid();
    }

    private boolean isValid() {
        assert !this.adaptee.isNull();

        ConcreteCoordinate concreteCoordinate = (ConcreteCoordinate) this.adaptee;
        return this.getLimitsRow().isIncluded(concreteCoordinate.getRow())
                && this.getLimitsColumn().isIncluded(concreteCoordinate.getColumn());
    }

    protected ClosedInterval getLimitsRow() {
        return new ClosedInterval(0, this.getDimensionRow() - 1);
    }

    protected ClosedInterval getLimitsColumn() {
        return new ClosedInterval(0, this.getDimensionColumn() - 1);
    }

    protected abstract int getDimensionRow();
    protected abstract int getDimensionColumn();

    public Direction getDirection(SquareBoundedCoordinate coordinate) {
        if (this.equals(coordinate) || this.isNull() || coordinate.isNull()) {
            return Direction.NULL;
        }
        return this.adaptee.getDirection(coordinate.adaptee);
    }

    /* public void read(String message) {
        assert message != null;

        this.adaptee = new ConcreteCoordinate();
        ConcreteCoordinate coordinate = (ConcreteCoordinate) this.adaptee;
        boolean error;
        do {
            coordinate.read(message);
            error = !this.isValid();
            if (error) {
                Console.getInstance().writeln(this.getErrorMessage());
            }
        } while (error);
    } */

    protected abstract String getErrorMessage();

    public int getRow() {
        assert !this.adaptee.isNull();

        return ((ConcreteCoordinate) this.adaptee).getRow();
    }

    public int getColumn() {
        assert !this.adaptee.isNull();

        return ((ConcreteCoordinate) this.adaptee).getColumn();
    }

}
