package connectfour;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private List<Coordinate> coordinates;

    Line(Coordinate lastCoordinate, Direction direction) {
        this.coordinates = new ArrayList<>(ConnectFour.CONNECT_FOUR);
        this.completeLine(lastCoordinate, direction);
    }

    private void completeLine(Coordinate lastCoordinate, Direction direction) {
        assert direction != null;

        int coordinatesInLine = 0;
        Coordinate currentCoordinate = lastCoordinate;
        int invalidCoordinates = 0;

        do {
            if (!currentCoordinate.isValid()) {
                direction.opposite();
                invalidCoordinates++;
                currentCoordinate = lastCoordinate.nextCoordinate(direction);
            } else {
                this.coordinates.add(currentCoordinate);
                coordinatesInLine++;
                currentCoordinate = currentCoordinate.nextCoordinate(direction);
            }
        } while (invalidCoordinates < 2 && coordinatesInLine < 4);

    }

    /* private void moveLine(Direction direction) {
        List<Coordinate> movedCoordinates = new ArrayList<>();
        for (Coordinate coordinate : this.coordinates) {
            movedCoordinates.add(new Coordinate(coordinate.getRow() + direction.getRowIncrement(), coordinate.getColumn() + direction.getColumnIncrement()));
        }
        this.coordinates = movedCoordinates;

    } */

    public List<Coordinate> getCoordinates() {
        return this.coordinates;
    }

    public void setCoordinates(List<Coordinate> coordinates) {
        this.coordinates = coordinates;
    }

}
