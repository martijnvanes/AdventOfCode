package puzzles;

import org.junit.jupiter.api.Test;
import util.FileHelper;

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
}