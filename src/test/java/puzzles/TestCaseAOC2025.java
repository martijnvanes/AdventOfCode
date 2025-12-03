package puzzles;

import models.numbers.PositionValue;
import org.junit.jupiter.api.Assertions;
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
                deltaInt = Integer.parseInt(deltaString.substring(deltaString.length() - 2));
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

    @Test
    public void dayOnePuzzleTwo() {
        int answer = 0;
        List<String> inputList = FileHelper.readFileToListOfString("2025-day01-input.txt");
        //List<String> inputList = FileHelper.readFileToListOfString("2025-day01-example.txt");
        int lowerLimit = 0;
        int upperLimit = 100;
        int startValue = 50;

        for (String input : inputList) {
            String direction = input.charAt(0) == 'L' ? "left" : "right";
            String deltaString = input.substring(1);
            int deltaInt;
            if (deltaString.length() > 2) {
                deltaInt = Integer.parseInt(deltaString.substring(deltaString.length() - 2));
                answer = answer + Integer.parseInt(deltaString.substring(0, deltaString.length() - 2));
            } else {
                deltaInt = Integer.parseInt(deltaString);
            }

            int calculatedValue = Calculator.dialLeftOrRightPartTwo(startValue, deltaInt, direction);

            if (calculatedValue < lowerLimit) {
                calculatedValue = calculatedValue + upperLimit;
                if (calculatedValue + deltaInt != 100) {
                    answer++;
                }
            } else if (calculatedValue == upperLimit) {
                calculatedValue = 0;

            } else if (calculatedValue > upperLimit) {
                calculatedValue = calculatedValue - upperLimit;
                answer++;
            }

            startValue = calculatedValue;
            if (calculatedValue == 0 || calculatedValue == 100) {
                answer++;
            }
        }
        System.out.println("The answer to the advent of code 2025 challenge day one puzzle two is: " + answer);
    }

    @Test
    public void dayTwoPuzzleOne() {
        long answer = 0;
        // List<String> inputList = FileHelper.readFileToListOfStringWithSeparator("2025-day02-example.txt", ",");
        List<String> inputList = FileHelper.readFileToListOfStringWithSeparator("2025-day02-input.txt", ",");
        for (String input : inputList) {
            String[] inputArray = input.split("-");
            long startValue = Long.parseLong(inputArray[0]);
            long endValue = Long.parseLong(inputArray[1]);

            for (long testValue = startValue; testValue <= endValue; testValue++) {
                String testValueString = String.valueOf(testValue);
                if (testValueString.length() != 1) {
                    int index = testValueString.length() / 2;
                    String compare1 = testValueString.substring(0, index);
                    String compare2 = testValueString.substring(index);
                    if (compare1.charAt(0) != '0' && compare1.equals(compare2)) {
                        answer = answer + testValue;
                    }
                }
            }
        }
        System.out.println("The answer to the advent of code 2025 challenge day two puzzle one is: " + answer);
    }

    @Test
    public void dayTwoPuzzleTwo() {
        long answer = 0;
        // List<String> inputList = FileHelper.readFileToListOfStringWithSeparator("2025-day02-example.txt", ",");
        List<String> inputList = FileHelper.readFileToListOfStringWithSeparator("2025-day02-input.txt", ",");
        for (String input : inputList) {
            String[] inputArray = input.split("-");
            long startValue = Long.parseLong(inputArray[0]);
            long endValue = Long.parseLong(inputArray[1]);
            for (long testValue = startValue; testValue <= endValue; testValue++) {
                String testValueString = String.valueOf(testValue);
                if (testValueString.length() != 1) {
                    if ((testValueString + testValueString).indexOf(testValueString, 1) != testValueString.length()) {
                        answer = answer + testValue;
                    }
                }
            }
        }
        System.out.println("The answer to the advent of code 2025 challenge day two puzzle two is: " + answer);
    }

    @Test
    public void dayThreePuzzleOne() {
        int answer = 0;
        List<String> inputList = FileHelper.readFileToListOfString("2025-day03-input.txt");
        for (String input : inputList) {
            int highestJoltage1Value = 0;
            int highestJoltage2Value = 0;
            int highestJoltage1Position = 0;
            int highestJoltage2Position = 0;
            for (int i = input.length(); i > 0; i--) {
                if (i != input.length() && (int) input.charAt(i - 1) - (int) '0' >= highestJoltage1Value) {
                    highestJoltage1Value = ((int) input.charAt(i - 1) - (int) '0');
                    highestJoltage1Position = i;
                }
            }
            for (int j = input.length(); j > highestJoltage1Position; j--) {
                if ((int) input.charAt(j - 1) - (int) '0' > highestJoltage2Value) {
                    highestJoltage2Value = ((int) input.charAt(j - 1) - (int) '0');
                    highestJoltage2Position = j;
                }
            }
            System.out.println("Highest Joltage 1 = " + highestJoltage1Value + " on position " + highestJoltage1Position);
            System.out.println("Highest Joltage 2 = " + highestJoltage2Value + " on position " + highestJoltage2Position);
            answer = answer + Integer.parseInt(String.valueOf(highestJoltage1Value) + String.valueOf(highestJoltage2Value));

        }
        System.out.println("The answer to the advent of code 2025 challenge day three puzzle one is: " + answer);
    }

    @Test
    public void dayThreePuzzleTwo() {
        long answer = 0;
        List<String> inputList = FileHelper.readFileToListOfString("2025-day03-input.txt");
        int iterations = 12;
        for (String input : inputList) {
            int leftStopper = 0;
            StringBuilder jolt = new StringBuilder();
            for (int i = iterations; i > 0; i--) {
                int rightStopper = input.length() - i + 1;
                String stringToAnalyse = input.substring(leftStopper, rightStopper);
                PositionValue positionValue = Calculator.findHighestValueInRange(stringToAnalyse);
                leftStopper = leftStopper + positionValue.getPosition();
                jolt.append(positionValue.getValue());
            }
            answer = answer + Long.parseLong(jolt.toString());
        }
        System.out.println("The answer to the advent of code 2025 challenge day three puzzle two is: " + answer);
    }
}

// 818181911112111
// 881911112111
// 888911112111

// 8181
// 1818

// 8