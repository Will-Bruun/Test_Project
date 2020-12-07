package calculator;

import java.util.ArrayList;

public class StringCalculator {
    public int Add(String nums) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int sum = 0;
        if (nums == "") {
            return 0;
        }
        String[] split = nums.split(",");
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
