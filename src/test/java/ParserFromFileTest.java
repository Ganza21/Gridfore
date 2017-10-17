import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import parser.ParserFromFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Андрей on 15.10.2017.
 */
public class ParserFromFileTest {

    private List<String> testList;

    private Path path;

    @Before
    public void prepare() throws IOException {

        testList = Arrays.asList("first", "second", "third");
        PrintWriter pw = new PrintWriter(new FileOutputStream("tests.csv"));
        testList.forEach(pw::println);
        pw.close();
    }

    @Test
    public void testParseFromFile() throws IOException {

        List<String> result = ParserFromFile.getData("tests.csv");
        int i = 0;

            for (String line : result){

                Assert.assertEquals(testList.get(i), result.get(i));
                System.out.println(testList.get(i));
                System.out.println(result.get(i));
                i++;
        }

        Assert.assertEquals(testList.size(), result.size());

    }

}


