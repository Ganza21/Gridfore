import Ignite.IgniteData;
import model.CallDetail;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Андрей on 16.10.2017.
 */
public class IgniteDataTest {

    List<CallDetail> testList;
    IgniteData igniteData;

    @Before
    public void prepare(){
        igniteData = new IgniteData();
        testList = Arrays.asList(new CallDetail("5165513961,2017/04/02,3,105,5167278881,188.65"),
                                 new CallDetail("9603137957,2017/02/28,3,976,4233575832,5207.328"));
        igniteData.putDataToCache(testList);
    }

    @After
    public void after(){
        igniteData.closeIgnite();
    }

    @Test
    public void getSumVolumeFromCacheTest() throws FileNotFoundException {
        List<?> list1 = Arrays.asList(1081);
      //  List<?> list2 = Arrays.asList(list1);
        Assert.(igniteData.getSumVolumeFromCache().toArray(), list1.toArray());
    }
}
