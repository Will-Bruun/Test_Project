package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;


public class StringCalculatorTest {

    StringCalculator calc = new StringCalculator();

    @Test
    @DisplayName("Simple test to see if a couple of parameters return right value")
    void checkReturnTwoNumbers(){
        var result = 0;
        result = calc.Add("1;2");

        Assertions.assertEquals(3, result, "1 + 2 should be 3");
    }
    @Test
    void checkReturnOneNumber(){

        var result = 0;
        result = calc.Add("2");

        Assertions.assertEquals(2, result, "2 should be 2");
    }
    @Test
    void checkReturnEmptyInput(){

        var result = 0;
        result = calc.Add("");

        Assertions.assertEquals(0,result);
    }

    @Test
    @DisplayName("Check if NegativeArgumentError gets thrown")
    void checkNegativeErrorThrown(){
        List<String> error = new ArrayList<>();
        error.add("-4");
        error.add("-1");
        error.add("5");
        Assertions.assertThrows(NegativeArgumentException.class, () -> calc.parseStringToInt(error));
    }

    @Test
    @DisplayName("Check if IllegalArgumentError gets thrown")
    void checkIllegalErrorThrown(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> calc.Add("1;2;a"));
    }

    @Test
    @DisplayName("Multiple types of delimiters along with several of them in a row")
    void checkDelimiterCapacity(){

        var result = 0;
        result = calc.Add("1;;2#######3");

        Assertions.assertEquals(6, result, "1 + 2 + 3 should be 6");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1\n2", "1,2,3", "1;5;6;2", "1#2#3#1001", "2###2"})
    void checkReturnVariedNumbers(String candidate){

        var result = 0;
        result = calc.Add(candidate);
        switch (candidate) {
            case "1,2" -> Assertions.assertEquals(3, result);
            case "1,2,3" -> Assertions.assertEquals(6, result);
            case "1;5;6;2" -> Assertions.assertEquals(14, result);
            case "2#2#3#1001" -> Assertions.assertEquals(7, result);
            case "4###2" -> Assertions.assertEquals(4, result);
        }

    }

}
