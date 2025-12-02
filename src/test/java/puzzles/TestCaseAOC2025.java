package puzzles;

import org.junit.jupiter.api.Test;
import util.Calculator;
import util.FileHelper;

import java.util.List;


public class TestCaseAOC2025 {
    @Test
    public void dayOnePuzzleOne() {
        int answer = 0;
        List<String> inputList = FileHelper.readFileToListOfString("2025-day01-input.txt");
        ///List<String> inputList = FileHelper.readFileToListOfString("2025-day01-example.txt");
        int lowerLimit = 0;
        int upperLimit = 100;
        int startValue = 50;

        for (String input : inputList) {
            String direction = input.charAt(0) == 'L' ? "left" : "right";
            String deltaString = input.substring(1);
            int deltaInt;
            if (deltaString.length() > 2) {
                deltaInt = Integer.parseInt(deltaString.substring(deltaString.length()-2));
            } else {
                deltaInt = Integer.parseInt(input.substring(1));
            }

            int calculatedValue = Calculator.dialLeftOrRight(lowerLimit, upperLimit, startValue, deltaInt, direction);
            startValue = calculatedValue;
            if (calculatedValue == 0 || calculatedValue == 100) {
                answer++;
            }
        }

        System.out.println("The answer to the advent of code 2025 challenge day one puzzle one is: " + answer);
    }
}
