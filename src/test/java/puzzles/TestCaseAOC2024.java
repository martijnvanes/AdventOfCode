package puzzles;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static util.ArrayHelper.*;
import static util.FileHelper.*;
import static util.StringHelper.*;

@Test
public class TestCaseAOC2024 {
    public void dayOnePuzzleOne() {
        int answer = 0;
        List<String> inputList = readFileToListOfString("2024/day01.txt");
        assert inputList != null;
        int[] col1 = new int[inputList.size()];
        int[] col2 = new int[inputList.size()];
        int i = 0;

        for (String input : inputList) {
            col1[i] = Integer.parseInt(input.substring(0, 5));
            col2[i] = Integer.parseInt(input.substring(8, 13));
            i++;
        }
        Arrays.sort(col1);
        Arrays.sort(col2);

        i = 0;
        while (i < inputList.size()) {
            answer = answer + Math.abs(col1[i] - col2[i]);
            i++;
        }

        System.out.println("The total distance between numbers on the left and right list is " + answer);
    }

    public void dayOnePuzzleTwo() {
        int similarityScoreTotal = 0;
        List<String> inputList = readFileToListOfString("2024/day01.txt");
        assert inputList != null;
        int[] col1 = new int[inputList.size()];
        int[] col2 = new int[inputList.size()];
        int i = 0;

        for (String input : inputList) {
            col1[i] = Integer.parseInt(input.substring(0, 5));
            col2[i] = Integer.parseInt(input.substring(8, 13));
            i++;
        }

        i = 0;
        while (i < inputList.size()) {
            int factor = countIntOccurencesInIntArray(col1[i], col2);
            int similarityScore = col1[i] * factor;
            similarityScoreTotal = similarityScoreTotal + similarityScore;
            i++;
        }
        System.out.println("The similarity score is " + similarityScoreTotal);
    }

    public void dayTwoPuzzleOne() {
        int numberOfSafeReports = 0;
        List<String> reports = readFileToListOfString("2024/day02.txt");
        assert reports != null;
        for (String report : reports) {
            int[] levels = splitStringToIntArray(report, " ");
            if (valuesAscendingWitMaxDifference(levels, 3)) {
                numberOfSafeReports++;
            }
            if (valuesDescendingWitMaxDifference(levels, 3)) {
                numberOfSafeReports++;
            }
        }
        System.out.println("There are " + numberOfSafeReports + " safe reports.");
    }

    public void dayTwoPuzzleTwo() {
        int numberOfSafeReports = 0;
        List<String> reports = readFileToListOfString("2024/day02.txt");
        assert reports != null;
        for (String report : reports) {
            int[] levels = splitStringToIntArray(report, " ");

            int indexToRemove;
            if (levels[0] < levels[levels.length - 1]) {
                indexToRemove = valuesAscendingWitMaxDifferenceRemoveOne(levels, 3);
            } else {
                indexToRemove = valuesDescendingWitMaxDifferenceRemoveOne(levels, 3);
            }

            int[] levelsCleaned;
            if (indexToRemove != 999) {
                levelsCleaned = removeIndexFromIntArray(levels, indexToRemove);
            } else {
                levelsCleaned = levels;
            }
            if (valuesAscendingWitMaxDifference(levelsCleaned, 3)) {
                numberOfSafeReports++;
            }
            if (valuesDescendingWitMaxDifference(levelsCleaned, 3)) {
                numberOfSafeReports++;
            }
        }
        System.out.println("There are " + numberOfSafeReports + " safe reports.");
    }

    public void dayThreePuzzleOne() {
        String input = readFileToString("2024/day03.txt");
        String regEx = "mul\\([0-9]{1,3},[0-9]{1,3}\\)";
        List<String> realMulInstructions = returnListOfStringByRegEx(regEx, input);
        int answer = 0;

        for (String realMulInstruction : realMulInstructions) {
            String formula = realMulInstruction.substring(4);
            formula = formula.substring(0, formula.length() - 1);
            String[] array = formula.split(",");
            int a = Integer.parseInt(array[0]);
            int b = Integer.parseInt(array[1]);
            answer = answer + (a * b);
        }
        System.out.println("There answer is " + answer);
    }

    public void dayFourPuzzleOne() {
        int counter = 0;
        int rows = 140;
        int cols = 140;
        String[][] input = readFileTo2DArrayOfString("2024/day04.txt", rows, cols, "");
        assert input != null;
        int i = 0;
        while (i < rows) {
            int j = 0;
            while (j < cols) {
                if (input[i][j].equals("X")) {
                    if (horizontalSearchL2R(input, i, j, cols, rows)) {
                        counter++;
                    }
                    if (horizontalSearchR2L(input, i, j, cols, rows)) {
                        counter++;
                    }
                    if (verticalSearchU2D(input, i, j, cols, rows)) {
                        counter++;
                    }
                    if (verticalSearchD2U(input, i, j, cols, rows)) {
                        counter++;
                    }
                    if (diagonalSearchL2RD(input, i, j, cols, rows)) {
                        counter++;
                    }
                    if (diagonalSearchL2RU(input, i, j, cols, rows)) {
                        counter++;
                    }
                    if (diagonalSearchR2LU(input, i, j, cols, rows)) {
                        counter++;
                    }
                    if (diagonalSearchR2LD(input, i, j, cols, rows)) {
                        counter++;
                    }
                }
                j++;
            }
            i++;
        }
        System.out.println("The answer is: " + counter);
    }

    public void dayFourPuzzleTwo() {
        int counter = 0;
        int rows = 140;
        int cols = 140;
        String[][] input = readFileTo2DArrayOfString("2024/day04.txt", rows, cols, "");
        assert input != null;
        int i = 0;

        while (i < rows) {
            int j = 0;
            while (j < cols) {
                if (input[i][j].equals("A")) {
                    if (findXshapeA(input, i, j, cols, rows)) {
                        counter++;
                    }
                    if (findXshapeB(input, i, j, cols, rows)) {
                        counter++;
                    }
                    if (findXshapeC(input, i, j, cols, rows)) {
                        counter++;
                    }
                    if (findXshapeD(input, i, j, cols, rows)) {
                        counter++;
                    }
                }
                j++;
            }
            i++;
        }

        System.out.println("The answer is: " + counter);
    }
}