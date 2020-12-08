package calculator;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class StringCalculator{
    public int Add(String nums) throws NegativeArgumentException {
        if (nums.equals("")) {
            return 0;
        }
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> negatives = new ArrayList<>();
        Pattern pattern = Pattern.compile(",|;|\n|#|&|%|\\*|\\\\\\\\|/|//");
        int sum = 0;
        String[] split = pattern.split(nums);
        for(String num : split) {
            int temp = Integer.parseInt(num);
            if(temp < 0){
                negatives.add(temp);
            }
            else if(temp > 0){
                list.add(temp);
            }
        }
        if(negatives.size() > 0){
            throw new NegativeArgumentException("One or several numbers were negative. These numbers were invalid:" + negatives);
        }
        for(int i = 0; i < list.size(); i++){
            int temp = sum;
            sum = temp + list.get(i);
        }
        return sum;
    }
}
