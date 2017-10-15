import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Андрей on 14.10.2017.
 */
public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void prepare(){
        calculator = new Calculator();
    }

    @Test
    public void testCalcSum() throws Exception{
        System.out.println("Test Calc Sum!");
        assertEquals(30, calculator.calcSum(10, 20));
    }


}
