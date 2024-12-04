package puzzles;

import enums.Heading;
import models.arrayInstruction.Position;
import models.shapes.Triangle;
import org.testng.annotations.Test;
import util.*;

import java.util.ArrayList;
import java.util.List;

import static util.FileHelper.readFileTo2DArrayOfString;
import static util.ShapeHelper.triangleIsValid;

@Test
public class TestCaseAOC2016 {
    public void dayOnePuzzleOne() {
        int answer;
        String[] inputArray = FileHelper.readFileToArrayOfString("2016/day01-01.txt", true);

        Position position = new Position();
        position.startPosition(0, 0, Heading.NORTH);
        for (String inputString : inputArray) {
            String directionUpdate = inputString.substring(0, 1);
            int moves = Integer.parseInt(inputString.substring(1));
            position.updatePosition(directionUpdate, moves);
        }
        answer = Math.abs(position.getX()) + Math.abs(position.getY());
        System.out.println("The answer is:  = " + answer);
    }

    public void dayOnePuzzleTwo() {
        int answer;
        String[] inputArray = FileHelper.readFileToArrayOfString("2016/day01-01.txt", true);

        List<Position> positionList = new ArrayList<>();
        Position firstPosition = new Position();
        firstPosition.startPosition(0, 0, Heading.NORTH);
        positionList.add(firstPosition);

        for (String inputString : inputArray) {
            Position previousPosition = Position.copyPreviousPosition(positionList.getLast());
            Position newPosition = Position.copyPreviousPosition(positionList.getLast());
            newPosition = newPosition.updatePosition(inputString.substring(0, 1), Integer.parseInt(inputString.substring(1)));
            List<Position> route = Position.routeBetweenPositions(previousPosition, newPosition);
            Position positionVisitedForSecondTime = CoordinateHelper.visitingPositionForSecondTime(route, positionList);
            if (positionVisitedForSecondTime != null) {
                answer = Math.abs(positionVisitedForSecondTime.getX()) + Math.abs(positionVisitedForSecondTime.getY());
                System.out.println("The answer is:  = " + answer);
                break;
            } else {
                positionList.addAll(route);
            }
        }
    }

    public void dayTwoPuzzleOne() {
        List<String> inputStringList = FileHelper.readFileToListOfString("2016/day02-01.txt");
        assert inputStringList != null;

        String[][] keypad = {{"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"}};
        int row = 1; // Start row
        int rowMax = 2;
        int column = 1; // Start column
        int columnMax = 2;

        String answer = MdArrayHelper.returnContentsOfField(keypad, row, rowMax, column, columnMax, inputStringList);

        System.out.println(answer);
    }

    public void dayTwoPuzzleTwo() {
        List<String> inputStringList = FileHelper.readFileToListOfString("2016/day02-01.txt");
        assert inputStringList != null;

        String[][] keypad = {{"EDGE", "EDGE", "1", "EDGE", "EDGE"}, {"EDGE", "2", "3", "4", "EDGE"}, {"5", "6", "7", "8", "9"}, {"EDGE", "A", "B", "C", "EDGE"}, {"EDGE", "EDGE", "D", "EDGE", "EDGE"}};
        int row = 2; // Start row
        int rowMax = 4;
        int column = 0; // Start column
        int columnMax = 4;

        String answer = MdArrayHelper.returnContentsOfField(keypad, row, rowMax, column, columnMax, inputStringList);

        System.out.println(answer);
    }

    public void dayThreePuzzleOne() {
        List<String> inputStringList = FileHelper.readFileToListOfString("2016/day03-01.txt");
        assert inputStringList != null;

        int answer = 0;

        List<Triangle> triangleList = new ArrayList<>();
        for (String input : inputStringList) {
            triangleList.add(ShapeHelper.stringToTriangle(input));
        }
        for (Triangle triangle : triangleList) {
            if (triangleIsValid(triangle)){
                answer++;
            }
        }

        System.out.println("There are " + answer + " possible triangles.");
    }

    public void dayThreePuzzleTwo() {
        int answer = 0;

        String[][] inputStringArray = readFileTo2DArrayOfString("2016/day03-01.txt", 1911,3, ",");
        List<Triangle> triangleList = new ArrayList<>();
        triangleList.addAll(ShapeHelper.verticalArrayToTriangle(inputStringArray));

        for (Triangle triangle : triangleList) {
            if (triangleIsValid(triangle)){
                answer++;
            }
        }

        System.out.println("There are " + answer + " possible triangles.");
    }
}
