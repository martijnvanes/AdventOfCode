package util;

import java.util.HashSet;
import java.util.List;

public class ListHelper {
    public static HashSet<String> uniqueList(List<String> inputList) {
        return new HashSet<>(inputList);
    }
}