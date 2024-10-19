package util;

import models.arrayInstruction.Position;

import java.util.ArrayList;
import java.util.List;

public class CoordinateHelper {
    public static List<String> returnCoordinatesList(String movementString, int xPosition, int yPosition) {
        String[] movementArray = StringHelper.splitString(movementString, "");

        List<String> coordinatesList = new ArrayList<>();
        coordinatesList.add("X" + xPosition + "Y" + yPosition);

        for (String movement : movementArray) {
            switch (movement) {
                case "^" -> xPosition++;
                case "v" -> xPosition--;
                case "<" -> yPosition--;
                case ">" -> yPosition++;
            }
            coordinatesList.add("X" + xPosition + "Y" + yPosition);
        }
        return coordinatesList;
    }

    public static Position visitingPositionForSecondTime(Position position, List<Position> positionList) {
        for (Position visitedPosition : positionList) {
            if (visitedPosition.getX() == position.getX()
                    && visitedPosition.getY() == position.getY()) {
                return position;
            }
        }
        return null;
    }

    public static Position visitingPositionForSecondTime(List<Position> newPositionList, List<Position> positionList) {
        for (Position newPosition : newPositionList) {
            if (visitingPositionForSecondTime(newPosition, positionList) != null) {
                return visitingPositionForSecondTime(newPosition, positionList);
            }
        }
        return null;
    }
}
