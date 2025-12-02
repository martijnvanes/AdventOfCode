package util;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@UtilityClass
public class FileHelper {
    public String readFileToString(String fileName) {
        Path path = Path.of("src/test/resources/" + fileName);
        try {
                return Files.readString(path);
            } catch (IOException e) {
                log.error(e.getLocalizedMessage());
            }
            return null;
        }

    public List<String> readFileToListOfString(String fileName) {
        Path path = Path.of("src/test/resources/" + fileName);
        try {
            return Files.readAllLines(path);
        } catch (IOException e) {
            log.error(e.getLocalizedMessage());
        }
        return null;
    }

    public List<String> readFileToListOfStringWithSeparator(String fileName, String separator) {
        Path path = Path.of("src/test/resources/" + fileName);
        try {
            String inputString = Files.readString(path);
            return List.of(inputString.split(separator));
        } catch (IOException e) {
            log.error(e.getLocalizedMessage());
        }
        return null;
    }
}