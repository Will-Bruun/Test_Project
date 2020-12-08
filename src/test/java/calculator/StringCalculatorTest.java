package calculator;

import com.sun.source.tree.AssertTree;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class StringCalculatorTest {
    @Test
    @DisplayName("Simple test to see if a couple of parameters return right value")
    void checkReturnTwoNumbers(){
        StringCalculator calc = new StringCalculator();

        int result = 0;
        try {
            result = calc.Add("1;2");
        } catch (NegativeArgumentException e) {
            e.printStackTrace();
        }

        Assertions.assertEquals(3, result, "1 + 2 should be 3");
    }
    @Test
    void checkReturnOneNumber(){
        StringCalculator calc = new StringCalculator();

        int result = 0;
        try {
            result = calc.Add("2");
        } catch (NegativeArgumentException e) {
            e.printStackTrace();
        }

        Assertions.assertEquals(2, result, "2 should be 2");
    }
    @Test
    void checkReturnEmptyInput(){
        StringCalculator calc = new StringCalculator();

        int result = 0;
        try {
            result = calc.Add("");
        } catch (NegativeArgumentException e) {
            e.printStackTrace();
        }

        Assertions.assertEquals(0,result);
    }

    @Test
    @DisplayName("Check if NegativeArgumentError gets thrown")
    void checkErrorThrown(){
        StringCalculator calc = new StringCalculator();

        Assertions.assertThrows(NegativeArgumentException.class, () -> calc.Add("1,-3,-4"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1\n2", "1,2,3", "1;5;6;2"})
    void checkReturnVariednumbers(String candidate){
        StringCalculator calc = new StringCalculator();

        int result = 0;
        try {
            result = calc.Add(candidate);
        } catch (NegativeArgumentException e) {
            e.printStackTrace();
        }
        switch (candidate){
            case "1,2": Assertions.assertEquals(3, result);
            break;
            case "1,2,3": Assertions.assertEquals(6, result);
            break;
            case "1,5,6,2": Assertions.assertEquals(14, result);
            break;
        }

    }

}
