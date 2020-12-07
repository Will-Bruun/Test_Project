package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



public class StringCalculatorTest {
    @Test
    @DisplayName("Simple test to see if a couple of parameters return right value")
    void checkReturnTwoNumbers(){
        StringCalculator calc = new StringCalculator();

        int result = calc.Add("1,2");

        Assertions.assertEquals(3, result, "1 + 2 should be 3");
    }
    @Test
    void checkReturnOneNumber(){
        StringCalculator calc = new StringCalculator();

        int result = calc.Add("2");

        Assertions.assertEquals(2, result, "2 should be 2");
    }
    @Test
    void checkReturnNullNumbers(){
        StringCalculator calc = new StringCalculator();

        var result = calc.Add("");

        Assertions.assertEquals(0,result);
    }

}
