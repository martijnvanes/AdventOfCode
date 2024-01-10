package util;

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
}