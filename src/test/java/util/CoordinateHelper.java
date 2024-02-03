package util;

import java.lang.runtime.SwitchBootstraps;
import java.util.ArrayList;
import java.util.List;

public class CoordinateHelper {
    public static List<String> returnCoordinatesList(String movementString, int xPosition, int yPosition) {
        String[] movementArray = StringHelper.splitString(movementString, "");

        List<String> coordinatesList = new ArrayList<>();
        coordinatesList.add("X" + String.valueOf(xPosition) + "Y" + String.valueOf(yPosition));

        for (String movement : movementArray) {
            switch(movement) {
                case "^" -> xPosition++;
                case "v" -> xPosition--;
                case "<" -> yPosition--;
                case ">" -> yPosition++;
                coordinatesList.add("X" + String.valueOf(xPosition) + "Y" + String.valueOf(yPosition));
            }
        }
        return coordinatesList;
    }
}
