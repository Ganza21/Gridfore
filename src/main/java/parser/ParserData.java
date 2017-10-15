package parser;

import java.io.IOException;

/**
 * Created by Андрей on 15.10.2017.
 */
public class ParserData {

    public static void splitData() {

        try {
            for (String line : ParserFromFile.getData()) {
                System.out.println(line);


            }
        } catch (IOException exep) {
            System.out.println(exep);
        }
    }
}
