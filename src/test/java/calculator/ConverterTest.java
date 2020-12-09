package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ConverterTest {

    Pattern pattern = Pattern.compile(",|;|\n|#|&|%|\\*|\\\\\\\\|/|//");
    Converter converter = new Converter();

    @Test
    @DisplayName("Testing the converter")
    void checkNominalReturn(){
        String test = "1;2;3";
        List<String> expected = new ArrayList<>();
        expected.add("1");
        expected.add("2");
        expected.add("3");

        var result = converter.arrayToList(pattern, test);

        Assertions.assertEquals(expected, result);
    }
}
