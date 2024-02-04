package util;

import enums.Vowels;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ListHelper {
    public static HashSet<String> uniqueList(List<String> inputList) {
        return new HashSet<>(inputList);
    }

    public static List<String> removeIfContainsForbidden(List<String> stringList, String filterCriteria) {
        stringList.removeIf(string -> string.contains(filterCriteria));
        return stringList;
    }

    public static List<String> removeIfDoesNotContainNVowels(List<String> stringList, int numberOfVowels) {
        int sum;
        List<String> returnList = new ArrayList<>();
        for (String string : stringList) {
            int a = StringHelper.countOccurrencesOfCharacterInString('a', string);
            int e = StringHelper.countOccurrencesOfCharacterInString('e', string);
            int i = StringHelper.countOccurrencesOfCharacterInString('i', string);
            int o = StringHelper.countOccurrencesOfCharacterInString('o', string);
            int u = StringHelper.countOccurrencesOfCharacterInString('u', string);
            sum = a + e + i + o + u;
            if (sum >= numberOfVowels) {
                returnList.add(string);
            }
        }
        return returnList;
    }

    public static List<String> removeIfDoesNotContainMandatory(List<String> stringList, String filterCriteria) {
        for (String string : stringList) {
            if (!string.contains(filterCriteria)) {
                stringList.remove(string);
            }
        }
        return stringList;
    }
}