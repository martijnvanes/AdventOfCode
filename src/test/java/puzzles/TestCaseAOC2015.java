package puzzles;

import models.shapes.RectangularCuboid;
import org.junit.jupiter.api.Test;
import util.FileHelper;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import static util.Calculator.sumOfBigDecimalInList;
import static util.ShapeHelper.*;
import static util.StringHelper.countOccurrencesOfCharacterInString;
import static util.StringHelper.findPositionForThreshold;

public class TestCaseAOC2015 {
    @Test
    public void dayOnePuzzleOne() {
        int answer;
        String input = FileHelper.readFileToString("2015-day01.txt");

        int countUp = countOccurrencesOfCharacterInString('(', input);
        int countDown = countOccurrencesOfCharacterInString(')', input);
        answer = countUp - countDown;
        System.out.println("The answer to the advent of code 2015 challenge day one puzzle one is: " + answer);
    }

    @Test
    public void dayOnePuzzleTwo() {
        int answer;
        String input = FileHelper.readFileToString("2015-day01.txt");
        answer = findPositionForThreshold('(', ')', input, -1) + 1;
        System.out.println("The answer to the advent of code 2015 challenge day one puzzle two is: " + answer);
    }

    @Test
    public void dayTwoPuzzleOne() {
        List<String> input = FileHelper.readFileToListOfString("2015-day02.txt");
        assert input != null;
        List<RectangularCuboid> rectangularCuboidList = inputToCuboidShapeList(input, "x");
        Map<Integer, List<BigDecimal>> surfacesMap = calculateRectangularCuboidSurfaces(rectangularCuboidList);
        List<BigDecimal> rectangularCuboidSurfaceList = calculateRectangularCuboidCompleteSurfaceAddSmallestSurface(surfacesMap);
        BigDecimal answer = sumOfBigDecimalInList(rectangularCuboidSurfaceList);

        System.out.println("The answer to the advent of code 2015 challenge day two puzzle one is: " + answer);
    }
}