package Ignite;

import parser.ParserData;
import parser.ParserFromFile;

import java.io.IOException;

/**
 * Created by Андрей on 16.10.2017.
 */
public class SuperTraher {

    public static void run(String pathToFile) throws IOException {

       IgniteData igniteData = new IgniteData();

       igniteData.putDataToCache(ParserData.splitDataToObject(ParserFromFile.getData(pathToFile)));

    }
}
