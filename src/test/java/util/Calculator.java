package util;

import lombok.experimental.UtilityClass;

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
}