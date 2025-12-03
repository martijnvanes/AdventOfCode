package util;

import lombok.experimental.UtilityClass;
import models.numbers.PositionValue;

import java.math.BigDecimal;
import java.util.List;

public class Calculator {
    public static BigDecimal sumOfBigDecimalInList(List<BigDecimal> bigDecimalList) {
        BigDecimal answer = BigDecimal.ZERO;
        for (BigDecimal bigDecimal : bigDecimalList) {
            answer = answer.add(bigDecimal);
        }
        return answer;
    }

    public static int dialLeftOrRight(int lowerLimit, int upperLimit, int startValue, int delta, String direction) {
        int calculatedValue;
        if (direction.equals("left")) {
            calculatedValue = startValue - delta;
        } else {
            calculatedValue = startValue + delta;
        }
        if (calculatedValue < lowerLimit) {
            calculatedValue = calculatedValue + upperLimit;
        } else if (calculatedValue > upperLimit) {
            calculatedValue = calculatedValue - upperLimit;
        }
        return calculatedValue;
    }

    public static int dialLeftOrRightPartTwo(int startValue, int delta, String direction) {
        int calculatedValue;
        if (direction.equals("left")) {
            calculatedValue = startValue - delta;
        } else {
            calculatedValue = startValue + delta;
        }
        return calculatedValue;
    }

    public static PositionValue findHighestValueInRange(String inputRange) {
        PositionValue positionValue = new PositionValue();
        int highestJoltageValue = 0;
        int highestJoltagePosition = 0;
        for (int i = inputRange.length(); i > 0; i--) {
            if ((int) inputRange.charAt(i - 1) - (int) '0' >= highestJoltageValue) {
                highestJoltageValue = ((int) inputRange.charAt(i - 1) - (int) '0');
                highestJoltagePosition = i;
            }
        }
        positionValue.setPosition(highestJoltagePosition);
        positionValue.setValue(String.valueOf(highestJoltageValue));
        return positionValue;
    }
}