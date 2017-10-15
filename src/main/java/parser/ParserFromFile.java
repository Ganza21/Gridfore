package parser;

import java.io.*;
import java.nio.file.*;
import java.util.List;

/**
 * Created by Андрей on 15.10.2017.
 */
public interface ParserFromFile {

    /**
     *
     * @param pathToFile
     * @return
     * @throws IOException
     */
    static List<String> getData(String pathToFile) throws IOException {

        Path path = Paths.get(pathToFile);
        List<String> dataSet = Files.readAllLines(path);

        System.out.println(dataSet);
        return dataSet;
    }
}

