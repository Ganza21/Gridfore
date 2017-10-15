package parser;

import java.io.*;
import java.nio.file.*;
import java.util.List;

/**
 * Created by Андрей on 15.10.2017.
 */
public class ParserFromFile {

    /**
     *
     * @throws FileNotFoundException
     */
    public static void getData() throws FileNotFoundException {

        Path path = Paths.get("C:/TestProjects/testIgnite/callstorage/testData.csv");

        try {
            List<String> listData = Files.readAllLines(path);

            for (String line : listData) {
                System.out.println(line);
            }
        } catch (IOException ex){
            System.out.println(ex);
        }

    }
}

