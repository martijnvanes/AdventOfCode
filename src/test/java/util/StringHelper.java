package util;

import java.util.Objects;

public class StringHelper {
    public static int countOccurencesOfCharacterInString(char character, String inputString) {
        int count = 0;
        for (int i = 0; i < Objects.requireNonNull(inputString).length(); i++) {
            if (inputString.charAt(i) == character) {
                count++;
            }
        }
        return count;
    }
}
