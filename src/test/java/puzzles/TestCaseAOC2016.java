package puzzles;

import enums.Heading;
import models.arrayInstruction.Position;
import org.testng.annotations.Test;
import util.CoordinateHelper;
import util.FileHelper;
import util.StringHelper;

import java.util.ArrayList;
import java.util.List;

@Test
public class TestCaseAOC2016 {
    public void dayOnePuzzleOne() {
        int answer;
        String[] inputArray = FileHelper.tradFileToArrayOfString("2016/day01-01.txt", true);

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
        String[] inputArray = FileHelper.tradFileToArrayOfString("2016/day01-01.txt", true);

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
        int answer;
    }
}
