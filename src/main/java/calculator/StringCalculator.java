package calculator;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class StringCalculator {
    public int Add(String nums) {
        if (nums.equals("")) {
            return 0;
        }
        ArrayList<Integer> list = new ArrayList<>();
        Pattern pattern = Pattern.compile(",|;|\n|#|&|%|\\*|\\\\\\\\|/|//");
        int sum = 0;
        String[] split = pattern.split(nums);
        for (String num : split) {
            list.add(Integer.parseInt(num));
        }
        for(int i = 0; i < list.size(); i++){
            int temp = sum;
            sum = temp + list.get(i);
        }
        return sum;
    }
}
