package by.epam.secondtask.reader;

import by.epam.secondtask.exception.TextException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class TextReader {
    public static final Logger LOGGER = LogManager.getLogger();

    public String readText(String filePath) throws TextException {
        String text;
        try {
            text = new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            LOGGER.log(Level.ERROR, "file is missing", e);
            throw new TextException("file is missing", e);
        }
        return text;
    }
}
