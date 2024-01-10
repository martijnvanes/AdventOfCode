package puzzles;

import org.junit.jupiter.api.Test;
import util.FileHelper;

import static util.StringHelper.countOccurencesOfCharacterInString;

public class TestCaseAOC2015 {
    @Test
    public void dayOnePuzzleOne() {
        int answer;
        String input = FileHelper.readFileToString("2015-day01-01.txt");

        int countUp = countOccurencesOfCharacterInString('(', input);
        int countDown = countOccurencesOfCharacterInString(')', input);
        answer = countUp - countDown;
        System.out.println("The answer to the advent of code 2015 challenge day one puzzle one is: " + answer);
    }
}