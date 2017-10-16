package parser;

import java.io.*;
import java.nio.file.*;
import java.util.List;

/**
 * Created by Андрей on 15.10.2017.
 */
public interface ParserFromFile {

    /**
     * The method reads data from a file
     * @param pathToFile
     * @return List<String> dataSet
     * @throws IOException
     */
    static List<String> getData(String pathToFile) throws IOException {

        Path path = Paths.get(pathToFile);
        List<String> dataSet = Files.readAllLines(path);

        return dataSet;
    }
}

