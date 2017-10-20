import model.CallDetail;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import parser.ParserData;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static model.CallDetail.FORMAT;

/**
 * Created by Андрей on 16.10.2017.
 */
public class ParserDataTest {
    CallDetail callDetail = new CallDetail();
    List<String> testString;

    @Before
    public void prepare() {
        callDetail.setNumber("5165513961");
        callDetail.setDate(LocalDate.parse("2017/04/02", FORMAT));
        callDetail.setTranz(3);
        callDetail.setVolume(105);
        callDetail.setCalledNum("5167278881");
        callDetail.setCharge(BigDecimal.valueOf(188.65));
        testString = new ArrayList<>();
        testString.add("5165513961,2017/04/02,3,105,5167278881,188.65");
    }

    @Test
    public void testParseData() throws IOException {
        Assert.assertTrue(callDetail.equals(ParserData.splitDataToObject(testString).get(0)));
        Assert.assertEquals(callDetail, ParserData.splitDataToObject(testString).get(0));
    }
}


