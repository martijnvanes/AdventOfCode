package puzzles;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static util.ArrayHelper.countIntOccurencesInIntArray;
import static util.FileHelper.*;

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
            col1[i] = Integer.parseInt(input.substring(0,5));
            col2[i] = Integer.parseInt(input.substring(8,13));
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
            col1[i] = Integer.parseInt(input.substring(0,5));
            col2[i] = Integer.parseInt(input.substring(8,13));
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
}

