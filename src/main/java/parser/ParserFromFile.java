package parser;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Андрей on 15.10.2017.
 */
public class ParserFromFile {

    /**
     * @throws FileNotFoundException
     */
    public static List<String> getData() throws FileNotFoundException {

        List<String> dataSet = new ArrayList<>();

        Path path = Paths.get("C:/TestProjects/testIgnite/callstorage/testData.csv");
        if (Files.isReadable(path)) {

            System.out.println("Успешно прочитал файл))");
            try {
                List<String> listData = Files.readAllLines(path);

                for (String line : listData) {
                 //   System.out.println(line);
                    dataSet.add(line);

                }
            } catch (IOException ex) {
                System.out.println(ex);
            }

        } else {
            System.out.println("Файл нечитаемый");
        }
        return dataSet;
    }
}

