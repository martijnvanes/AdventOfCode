package util;

import org.apache.commons.codec.digest.DigestUtils;

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

    public static String calculateMD5Hash(String inputString) {
        return DigestUtils.md5Hex(inputString).toUpperCase();
    }
}