package connectfour;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final Direction direction;
    private final List<Coordinate> coordinates;

    Line(Coordinate lastCoordinate, Direction direction, Board board) {
        this.direction = direction;
        this.coordinates = new ArrayList<>(ConnectFour.CONNECT_FOUR);
        this.completeInitialLine(lastCoordinate, board);
    }

    private void completeInitialLine(Coordinate lastCoordinate, Board board) {
        int coordinatesInLine = 0;
        int senseChanges = 0;
        Coordinate currentCoordinate = lastCoordinate;
        this.direction.reset();
        do {
            if (!board.isValidCoordinate(currentCoordinate)) {
                this.direction.directionToMove();
                senseChanges++;
                currentCoordinate = lastCoordinate.nextCoordinate(this.direction.getSense());
            } else {
                this.coordinates.add(currentCoordinate);
                coordinatesInLine++;
                currentCoordinate = currentCoordinate.nextCoordinate(this.direction.getSense());
            }
        } while (senseChanges < 2 && coordinatesInLine < ConnectFour.CONNECT_FOUR);

    }

    public boolean isMovable(Coordinate lastCoordinate, Board board) {
        this.direction.directionToMove();
        boolean containsLastCoordinate = false;
        boolean areAllCoordinatesMovable = true;
        Coordinate nextCoordinate;
        for (Coordinate coordinate : this.coordinates) {
            nextCoordinate = coordinate.nextCoordinate(this.direction.getSense());
            if (!board.isValidCoordinate(nextCoordinate)) {
                areAllCoordinatesMovable = false;
            }
            if (nextCoordinate.equals(lastCoordinate)) {
                containsLastCoordinate = true;
            }
        }
        return areAllCoordinatesMovable && containsLastCoordinate;
    }

    public void move() {
        this.direction.directionToMove();
        this.coordinates.replaceAll(coordinate -> coordinate.nextCoordinate(this.direction.getSense()));
    }

    public List<Coordinate> getCoordinates() {
        return this.coordinates;
    }

}
