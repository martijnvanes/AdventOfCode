package util;

import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Slf4j
public class StringHelper {
    public static int countOccurrencesOfCharacterInString(char character, String inputString) {
        int count = 0;
        for (int i = 0; i < Objects.requireNonNull(inputString).length(); i++) {
            if (inputString.charAt(i) == character) {
                count++;
            }
        }
        return count;
    }

    public static int findPositionForThreshold(char charUp, char charDown, String inputString, int threshold) {
        int count = 0;
        int i;
        for (i = 0; i < Objects.requireNonNull(inputString).length(); i++) {
            if (inputString.charAt(i) == charUp) {
                count++;
            } else if (inputString.charAt(i) == charDown) {
                count--;
            } else log.error("Unexpected character " + inputString.charAt(i));
            if (count == threshold) {
                break;
            }
        }
        return i;
    }
}
