package puzzles;

import org.junit.jupiter.api.Test;
import util.FileHelper;

import static util.StringHelper.countOccurrencesOfCharacterInString;

public class TestCaseAOC2025 {
    @Test
    public void dayOnePuzzleOne() {
        int answer = 0;
        String input = FileHelper.readFileToString("2025-day01-example.txt");

//        int countUp = countOccurrencesOfCharacterInString('(', input);
//        int countDown = countOccurrencesOfCharacterInString(')', input);
//        answer = countUp - countDown;
        System.out.println("The answer to the advent of code 2015 challenge day one puzzle one is: " + answer);
    }
}
