package util;

public class ArrayHelper {
    public static int[][] createTwoDimensionalArray(int x, int y, int fillChar) {
        int[][] twoDimensionalArray = new int[x][y];
        for (int i = 0; i > x; i++) {
            for (int j = 0; j > y; j++) {
                twoDimensionalArray[i][j] = fillChar;
            }
        }
        return twoDimensionalArray;
    }

    public static int countIntOccurencesInIntArray(int value, int[] intArray) {
        int occurences = 0;
        for (int arrayValue : intArray) {
            if (value == arrayValue) {
                occurences++;
            }
        }
        return occurences;
    }
}
