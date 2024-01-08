package puzzles;

import org.junit.jupiter.api.Test;
import util.FileHelper;

import java.util.Objects;

public class Puzzle2015 {
    @Test
    public void dayOnePuzzleOne() {
        int answer;
        char floorUp = '(';
        int countUp = 0;
        int countDown = 0;

        String inupt = FileHelper.readFileToString("2015-day01-01.txt");
        for (int i = 0; i < Objects.requireNonNull(inupt).length(); i++) {
            if (inupt.charAt(i) == floorUp) {
                countUp++;
            } else {
                countDown++;
            }
        }
        answer = countUp - countDown;
        System.out.println(answer);
    }
}
