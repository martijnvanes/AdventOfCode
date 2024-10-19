package util;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

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

    public static String[] tradFileToArrayOfString(String filename, boolean removeSpace) {
        String input = readFileToString(filename);
        if (removeSpace) {
            input = input.replaceAll("\\s", "");
        }
        return StringHelper.splitString(input, ",");
    }
}