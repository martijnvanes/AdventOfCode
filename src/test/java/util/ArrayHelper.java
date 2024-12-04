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

    public static boolean valuesAscendingWitMaxDifference(int[] values, int maxDifference) {
        int i = 0;
        boolean answer = false;
        int valuesAscending = 0; // counter increases when values are NOT ascending
        while (i < values.length) {
            if (i > 0) {
                int previousValue = values[i - 1];
                int value = values[i];
                if (previousValue >= value) {
                    valuesAscending++;
                } else if ((value - previousValue) > maxDifference) {
                    valuesAscending++;
                }
            }
            i++;
        }
        if (valuesAscending == 0) {
            answer = true;
        }
        return answer;
    }

    public static boolean valuesDescendingWitMaxDifference(int[] values, int maxDifference) {
        int i = 0;
        boolean answer = false;
        int valuesAscending = 0; // counter increases when values are NOT descending
        while (i < values.length) {
            if (i > 0) {
                int previousValue = values[i - 1];
                int value = values[i];
                if (previousValue <= value) {
                    valuesAscending++;
                } else if ((previousValue - value) > maxDifference) {
                    valuesAscending++;
                }
            }
            i++;
        }
        if (valuesAscending == 0) {
            answer = true;
        }
        return answer;
    }

    public static int valuesAscendingWitMaxDifferenceRemoveOne(int[] values, int maxDifference) {
        int i = 0;
        int index = 999;
        if (values[0] >= values[1]) {
            index = i;
            return index;
        } else {
            while (i < values.length) {
                if (i > 0) {
                    int previousValue = values[i - 1];
                    int value = values[i];
                    if (previousValue >= value) {
                        index = i;
                    } else if ((value - previousValue) > maxDifference) {
                        index = i;
                    }
                }
                i++;
            }
        }
        return index;
    }

    public static int valuesDescendingWitMaxDifferenceRemoveOne(int[] values, int maxDifference) {
        int i = 0;
        int index = 999;
        if (values[0] <= values[1]) {
            index = i;
            return index;
        }
        while (i < values.length) {
            if (i > 0) {
                int previousValue = values[i - 1];
                int value = values[i];
                if (previousValue <= value) {
                    index = i;
                } else if ((previousValue - value) > maxDifference) {
                    index = i;
                }
            }
            i++;
        }
        return index;
    }

    public static int[] removeIndexFromIntArray(int[] intArray, int indexToRemove) {
        int[] intArrayCleaned = new int[(intArray.length) - 1];
        int i = 0;
        int j = 0;
        while (i < intArray.length) {
            if (i != indexToRemove) {
                intArrayCleaned[j] = intArray[i];
                j++;
            }
            i++;
        }
        return intArrayCleaned;
    }

    public static boolean horizontalSearchL2R(String[][] input, int i, int j, int cols, int rows) {
        if ((j + 3) >= cols) {
            return false;
        }
        if (input[i][j + 1].equals("M")) {
            if (input[i][j + 2].equals("A")) {
                return input[i][j + 3].equals("S");
            }
        }
        return false;
    }

    public static boolean horizontalSearchR2L(String[][] input, int i, int j, int cols, int rows) {
        if ((j - 3) < 0) {
            return false;
        }
        if (input[i][j - 1].equals("M")) {
            if (input[i][j - 2].equals("A")) {
                return input[i][j - 3].equals("S");
            }
        }
        return false;
    }

    public static boolean verticalSearchU2D(String[][] input, int i, int j, int cols, int rows) {
        if ((i + 3) >= rows) {
            return false;
        }
        if (input[i + 1][j].equals("M")) {
            if (input[i + 2][j].equals("A")) {
                return input[i + 3][j].equals("S");
            }
        }
        return false;
    }

    public static boolean verticalSearchD2U(String[][] input, int i, int j, int cols, int rows) {
        if ((i - 3) < 0) {
            return false;
        }
        if (input[i - 1][j].equals("M")) {
            if (input[i - 2][j].equals("A")) {
                return input[i - 3][j].equals("S");
            }
        }
        return false;
    }

    public static boolean diagonalSearchL2RD(String[][] input, int i, int j, int cols, int rows) {
        if (((j + 3) >= cols) || ((i + 3) >= rows)) {
            return false;
        }
        if (input[i + 1][j + 1].equals("M")) {
            if (input[i + 2][j + 2].equals("A")) {
                return input[i + 3][j + 3].equals("S");
            }
        }
        return false;
    }

    public static boolean diagonalSearchL2RU(String[][] input, int i, int j, int cols, int rows) {
        if (((j + 3) >= cols) || ((i - 3) < 0)) {
            return false;
        }
        if (input[i - 1][j + 1].equals("M")) {
            if (input[i - 2][j + 2].equals("A")) {
                return input[i - 3][j + 3].equals("S");
            }
        }
        return false;
    }

    public static boolean diagonalSearchR2LU(String[][] input, int i, int j, int cols, int rows) {
        if (((j - 3) < 0) || ((i - 3) < 0)) {
            return false;
        }
        if (input[i - 1][j - 1].equals("M")) {
            if (input[i - 2][j - 2].equals("A")) {
                return input[i - 3][j - 3].equals("S");
            }
        }
        return false;
    }

    public static boolean diagonalSearchR2LD(String[][] input, int i, int j, int cols, int rows) {
        if (((j - 3) < 0) || ((i + 3) >= rows)) {
            return false;
        }
        if (input[i + 1][j - 1].equals("M")) {
            if (input[i + 2][j - 2].equals("A")) {
                return input[i + 3][j - 3].equals("S");
            }
        }
        return false;
    }

    public static boolean findXshapeA(String[][] input, int i, int j, int cols, int rows) {
        if (((j - 1) < 0) || ((j + 1) >= cols) || ((i - 1) < 0) || ((i + 1) >= rows)) {
            return false;
        }
        return (input[i + 1][j - 1].equals("M")) && ((input[i + 1][j + 1].equals("M"))) && (input[i - 1][j - 1].equals("S")) && ((input[i - 1][j + 1].equals("S")));
    }

    public static boolean findXshapeB(String[][] input, int i, int j, int cols, int rows) {
        if (((j - 1) < 0) || ((j + 1) >= cols) || ((i - 1) < 0) || ((i + 1) >= rows)) {
            return false;
        }
        return (input[i + 1][j - 1].equals("S")) && ((input[i + 1][j + 1].equals("S"))) && (input[i - 1][j - 1].equals("M")) && ((input[i - 1][j + 1].equals("M")));
    }

    public static boolean findXshapeC(String[][] input, int i, int j, int cols, int rows) {
        if (((j - 1) < 0) || ((j + 1) >= cols) || ((i - 1) < 0) || ((i + 1) >= rows)) {
            return false;
        }
        return (input[i + 1][j - 1].equals("M")) && ((input[i + 1][j + 1].equals("S"))) && (input[i - 1][j - 1].equals("M")) && ((input[i - 1][j + 1].equals("S")));
    }

    public static boolean findXshapeD(String[][] input, int i, int j, int cols, int rows) {
        if (((j - 1) < 0) || ((j + 1) >= cols) || ((i - 1) < 0) || ((i + 1) >= rows)) {
            return false;
        }
        return (input[i + 1][j - 1].equals("S")) && ((input[i + 1][j + 1].equals("M"))) && (input[i - 1][j - 1].equals("S")) && ((input[i - 1][j + 1].equals("M")));
    }
}