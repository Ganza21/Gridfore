import Ignite.SuperTraher;
import parser.ParserData;
import parser.ParserFromFile;

/**
 * Created by Андрей on 14.10.2017.
 */
public class Main {

    public static void main(String[] args) throws Throwable{

       // System.out.println("Hello Gradle!");

//        ParserData.splitData();

        SuperTraher.run(args[0], args[1]);

    }

}
