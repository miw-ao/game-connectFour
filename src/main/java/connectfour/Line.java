package connectfour;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<Coordinate> coordinates;
    private final Direction direction;

    Line(Coordinate lastCoordinate, Direction direction) {
        this.coordinates = new ArrayList<>(ConnectFour.CONNECT_FOUR);
        this.direction = direction;
        this.completeInitialLine(lastCoordinate);
    }

    private void completeInitialLine(Coordinate lastCoordinate) {
        int coordinatesInLine = 0;
        Coordinate currentCoordinate = lastCoordinate;
        int invalidCoordinates = 0;
        this.direction.reset();
        do {
            if (!currentCoordinate.isValid()) {
                this.direction.opposite();
                invalidCoordinates++;
                currentCoordinate = lastCoordinate.nextCoordinate(this.direction);
            } else {
                this.coordinates.add(currentCoordinate);
                coordinatesInLine++;
                currentCoordinate = currentCoordinate.nextCoordinate(this.direction);
            }
        } while (invalidCoordinates < 2 && coordinatesInLine < 4);

    }

    public boolean isMoveable() {
        // TODO: La linea a parte de ser contenida en el tablero, hay que verificar que contenga la ultima ficha que se ha puesto (lastCoordinate)
        // En esta clase no se sabe lastCoordinate, habra que pasarselo por parametro
        this.direction.directionToMove();
        for (Coordinate coordinate : this.coordinates) {
            if (!coordinate.nextCoordinate(this.direction).isValid()) {
                return false;
            }
        }
        return true;
    }

    public void move() {
        this.direction.directionToMove();
        this.coordinates.replaceAll(coordinate -> coordinate.nextCoordinate(this.direction));
    }

    public List<Coordinate> getCoordinates() {
        return this.coordinates;
    }

}
