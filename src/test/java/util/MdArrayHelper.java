package util;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class MdArrayHelper {
    public static String returnContentsOfField(String[][] keypad, int row, int rowMax, int column, int columnMax, List<String> directionList) {
        StringBuilder answer = new StringBuilder();
        for (String direction : directionList) {
            String[] directionArray = StringHelper.splitString(direction, "|");
            for (String directionString : directionArray) {
                switch (directionString) {
                    case "U" -> {
                        if (row != 0) {
                            row--;
                        }
                        if ((keypad[row][column]).equals("EDGE")) {
                            row++;
                        }
                    }
                    case "D" -> {
                        if (row < rowMax) {
                            row++;
                        }
                        if ((keypad[row][column]).equals("EDGE")) {
                            row--;
                        }
                    }
                    case "L" -> {
                        if (column != 0) {
                            column--;
                        }
                        if ((keypad[row][column]).equals("EDGE")) {
                            column++;
                        }
                    }
                    case "R" -> {
                        if (column < columnMax) {
                            column++;
                        }
                        if ((keypad[row][column]).equals("EDGE")) {
                            column--;
                        }
                    }
                    default -> log.error("Unknown direction: " + directionString);
                }
            }
            answer.append(keypad[row][column]);
        }
        return answer.toString();
    }
}
