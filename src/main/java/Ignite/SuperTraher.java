package Ignite;

import parser.ParserData;
import parser.ParserFromFile;

import java.io.IOException;

/**
 * Created by Андрей on 16.10.2017.
 */
public class SuperTraher {
    /**
     * The execution method for the Main, collects and associates the methods of the remaining classes
     *
     * @param pathToFile
     * @param pathToOutFileSum
     * @param pathToOutFileCount
     * @throws IOException
     */
    public static void run(String pathToFile, String pathToOutFileSum, String pathToOutFileCount) throws IOException {
        IgniteData igniteData = new IgniteData();
        try {
            igniteData.putDataToCache(ParserData.splitDataToObject(ParserFromFile.getData(pathToFile)));
            igniteData.writeToFileSumVolume(igniteData.getSumVolumeFromCache(), pathToOutFileSum);
            igniteData.writeToFileCountCharge(igniteData.getCountEntryFromCache(), pathToOutFileCount);
        } finally {
            igniteData.closeIgnite();
        }
    }
}
