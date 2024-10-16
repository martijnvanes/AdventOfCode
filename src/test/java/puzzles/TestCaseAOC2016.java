package puzzles;

import enums.Heading;
import models.arrayInstruction.Position;
import org.testng.annotations.Test;
import util.FileHelper;
import util.StringHelper;

@Test
public class TestCaseAOC2016 {
    public void dayOnePuzzleOne() {
        int answer;
        String input = FileHelper.readFileToString("2016/day01-01.txt");
        input = input.replaceAll("\\s","");
        String[] inputArray = StringHelper.splitString(input, ",");

        Position position = new Position();
        position.setX(0);
        position.setY(0);
        position.setHeading(Heading.NORTH);
        for (String inputString : inputArray) {
            String directionUpdate = inputString.substring(0, 1);
            int moves = Integer.parseInt(inputString.substring(1));
            position.updatePosition(directionUpdate, moves);
        }
        System.out.println("X = " + position.getX() + " Y = " + position.getY());
    }
}
