package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;

public class StringCalculatorTest {

    StringCalculator calc = new StringCalculator();

    @Test
    @DisplayName("Simple test to see if a couple of parameters return right value")
    void checkReturnTwoNumbers(){
        var result = 0;
        result = calc.Add("1;2");

        assertThat(result).isEqualTo(3);
    }
    @Test
    void checkReturnOneNumber(){

        var result = 0;
        result = calc.Add("2");

        assertThat(result).isEqualTo(2);
    }
    @Test
    void checkReturnEmptyInput(){

        var result = 0;
        result = calc.Add("");

        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("Check if NegativeArgumentError gets thrown")
    void checkNegativeErrorThrown(){
        List<String> error = new ArrayList<>();
        error.add("-4");
        error.add("-1");
        error.add("5");

        assertThatThrownBy(() -> calc.parseStringToInt(error)).isInstanceOf(NegativeArgumentException.class).hasMessageContaining("invalid: [%s, %s]", "-4", "-1");
    }

    @Test
    @DisplayName("Check if IllegalArgumentException gets thrown")
    void checkIllegalErrorThrown(){
        assertThatThrownBy(() -> calc.Add("1;2;a")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Multiple types of delimiters along with several of them in a row")
    void checkDelimiterCapacity(){

        var result = 0;
        result = calc.Add("1;;2#######3");

        assertThat(result).isEqualTo(6);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1\n2", "1,2,3", "1;5;6;2", "1#2#3#1001", "2###2"})
    void checkReturnVariedNumbers(String candidate){

        var result = 0;
        result = calc.Add(candidate);
        switch (candidate) {
            case "1,2" -> assertThat(result).isEqualTo(3);
            case "1,2,3" -> assertThat(result).isEqualTo(6);
            case "1;5;6;2" -> assertThat(result).isEqualTo(14);
            case "2#2#3#1001" -> assertThat(result).isEqualTo(7);
            case "4###2" -> assertThat(result).isEqualTo(4);
        }

    }

}
