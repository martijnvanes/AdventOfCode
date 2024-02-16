package util;

import lombok.extern.slf4j.Slf4j;
import org.apache.maven.shared.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;
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

    public static int countOccurrencesOfStringInString(String searchString, String inputString) {
        return StringUtils.countMatches(inputString, searchString);
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

    public static List<String> letterAppearsTwiceInARow(List<String> inputList) {
        List<String> outputList = new ArrayList<>();
        for (String string : inputList) {
            boolean doubleLetter = string.contains("aa") || string.contains("bb") || string.contains("cc") || string.contains("dd") || string.contains("ee") || string.contains("ff") || string.contains("gg") || string.contains("hh") || string.contains("ii") || string.contains("jj") || string.contains("kk") || string.contains("ll") || string.contains("mm") || string.contains("nn") || string.contains("oo") || string.contains("pp") || string.contains("qq") || string.contains("rr") || string.contains("ss") || string.contains("tt") || string.contains("uu") || string.contains("vv") || string.contains("ww") || string.contains("xx") || string.contains("yy") || string.contains("zz");
            if (doubleLetter) {
                outputList.add(string);
            }
        }
        return outputList;
    }

    public static String[] splitString(String inputString, String splitter) {
        return inputString.split(splitter);
    }

    public static String returnPartOfStringBasedOnIndex(String inputString, int index, int increaseIndex) {
        int length = inputString.length() - 1;
        StringBuilder outputString = new StringBuilder();
        for (int i = index; i <= length; i = i + increaseIndex) {
            outputString.append(inputString.charAt(i));
        }
        return outputString.toString();
    }

    public static boolean setOfLettersUnique(int sizeOfSet, String inputString) {
        int stringLength = inputString.length();
        for (int i = 0; i <= stringLength - sizeOfSet; i++) {
            String searchString = inputString.substring(i, i + sizeOfSet);
            if (countOccurrencesOfStringInString(searchString, inputString) > 1) {
                return false;
            }
        }
        return true;
    }

    public static boolean determineStringHasRepeatingLetter(int skipPositions, String inputString) {
        int stringLength = inputString.length();
        for (int i = 0; i < stringLength - skipPositions - 1; i++) {
            String[] array = splitString(inputString, "");
            String A = array[i];
            String B = array[i + +1 + skipPositions];
            if (A.equals(B)) {
                return true;
            }
        }
        return false;
    }
}