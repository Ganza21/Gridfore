package parser;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Андрей on 15.10.2017.
 */
public interface ParserFromFile {

    /**
     * The method reads data from a files
     * @param pathToFile
     * @return List<String> dataSet
     * @throws IOException
     */
    static List<String> getData(String pathToFile) throws IOException {

        List<String> dataSet = new ArrayList<>();

        List<Path> fileList = Files.walk(Paths.get(pathToFile))
                .collect(Collectors.toList());

            fileList.forEach(path -> {
                try {
                    dataSet.addAll(Files.readAllLines(path));
                } catch (IOException ex) {
                    ex.printStackTrace();
                    }
            });
        return dataSet;
    }
}

