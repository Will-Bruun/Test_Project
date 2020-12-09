package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Converter {
    public List<String> arrayToList(Pattern pattern, String inp){
        String[] split = pattern.split(inp);
        List<String> temp = new ArrayList<>();
        temp.addAll(Arrays.asList(split));
        List<String> removeTarget = List.of("");
        temp.removeAll(removeTarget);

        return temp;
    }
}
