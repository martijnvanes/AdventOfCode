package util;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

@Slf4j
public class FileHelper {
    public static String readFileToString(String fileName) {
        Path path = Path.of("src/test/resources/" + fileName);
        try {
            return Files.readString(path);
        } catch (IOException e) {
            log.error(e.getLocalizedMessage());
        }
        return null;
    }

    public static List<String> readFileToListOfString(String fileName) {
        Path path = Path.of("src/test/resources/" + fileName);
        try {
            return Files.readAllLines(path);
        } catch (IOException e) {
            log.error(e.getLocalizedMessage());
        }
        return null;
    }

    public static String[] readFileToArrayOfString(String filename, boolean removeSpace) {
        String input = readFileToString(filename);
        if (removeSpace) {
            input = input.replaceAll("\\s", "");
        }
        return StringHelper.splitString(input, ",");
    }

    public static String[][] readFileTo2DArrayOfString(String filename, int rows, int cols, String spliter) {
        try {
            Scanner scanner = new Scanner(new BufferedReader(new FileReader("src/test/resources/" + filename)));
            String[][] myArray = new String[rows][cols];
            while (scanner.hasNextLine()) {
                for (int i = 0; i < myArray.length; i++) {
                    String[] lineArray = scanner.nextLine().trim().replaceAll(" {1,}", ",").split(spliter);
                    for (int j = 0; j < lineArray.length; j++) {
                        myArray[i][j] = lineArray[j];
                    }
                }
            }
            return myArray;
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
        }
        return null;
    }

    public static int[][] readFileTo2DArrayOfInt(String filename, int rows, int cols) {
        try {
            Scanner scanner = new Scanner(new BufferedReader(new FileReader("src/test/resources/" + filename)));
            int[][] intArray = new int[rows][cols];
            while (scanner.hasNextLine()) {
                for (int i = 0; i < intArray.length; i++) {
                    String[] lineArray = scanner.nextLine().trim().replaceAll(" {1,}", ",").split(",");
                    for (int j = 0; j < lineArray.length; j++) {
                        intArray[i][j] = Integer.parseInt(lineArray[j]);
                    }
                }
            }
            return intArray;
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
        }
        return null;
    }
}