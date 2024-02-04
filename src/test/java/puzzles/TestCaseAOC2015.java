package puzzles;

import models.shapes.RectangularCuboid;
import org.junit.jupiter.api.Test;
import util.CoordinateHelper;
import util.FileHelper;
import util.ListHelper;
import util.StringHelper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
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
        List<RectangularCuboid> rectangularCuboidList = transformInputToCuboidShapeList(input, "x");
        Map<Integer, List<BigDecimal>> surfacesMap = calculateRectangularCuboidSurfaces(rectangularCuboidList);
        List<BigDecimal> rectangularCuboidSurfaceList = calculateRectangularCuboidCompleteSurfaceAddSmallestSurface(surfacesMap);
        BigDecimal answer = sumOfBigDecimalInList(rectangularCuboidSurfaceList);

        System.out.println("The answer to the advent of code 2015 challenge day two puzzle one is: " + answer);
    }

    @Test
    public void dayTwoPuzzleTwo() {
        List<String> input = FileHelper.readFileToListOfString("2015-day02.txt");
        assert input != null;
        List<RectangularCuboid> rectangularCuboidList = transformInputToCuboidShapeList(input, "x");
        List<BigDecimal> shortestDistanceAroundSides = calculateRectangularCuboidShortestDistanceAroundSides(rectangularCuboidList);
        List<BigDecimal> bows = calculateBows(rectangularCuboidList);
        BigDecimal answer = sumOfBigDecimalInList(shortestDistanceAroundSides).add(sumOfBigDecimalInList(bows));
        System.out.println("The answer to the advent of code 2015 challenge day two puzzle two is: " + answer);
    }

    @Test
    public void dayThreePuzzleOne() {
        String input = FileHelper.readFileToString("2015-day03.txt");
        List<String> coordinateList = CoordinateHelper.returnCoordinatesList(input, 0, 0);
        HashSet<String> coordinateListNoDuplicates = ListHelper.uniqueList(coordinateList);
        int answer = coordinateListNoDuplicates.size();
        System.out.println("The answer to the advent of code 2015 challenge day three puzzle one is: " + answer);
    }

    @Test
    public void dayThreePuzzleTwo() {
        String input = FileHelper.readFileToString("2015-day03.txt");
        assert input != null;
        List<String> coordinateList = new ArrayList<>();

        String santa = StringHelper.returnPartOfStringBasedOnIndex(input, 0,2);
        String roboSanta = StringHelper.returnPartOfStringBasedOnIndex(input, 1, 2);

        List<String> coordinateListSanta = CoordinateHelper.returnCoordinatesList(santa, 0, 0);
        List<String> coordinateListRoboSanta = CoordinateHelper.returnCoordinatesList(roboSanta, 0, 0);
        coordinateList.addAll(coordinateListSanta);
        coordinateList.addAll(coordinateListRoboSanta);
        HashSet<String> coordinateListNoDuplicates = ListHelper.uniqueList(coordinateList);
        int answer = coordinateListNoDuplicates.size();
        System.out.println("The answer to the advent of code 2015 challenge day three puzzle two is: " + answer);
    }
}