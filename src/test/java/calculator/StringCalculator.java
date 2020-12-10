package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class StringCalculator{

    Converter con = new Converter();
    ArrayList<Integer> list = new ArrayList<>();
    ArrayList<Integer> negatives = new ArrayList<>();
    Pattern pattern = Pattern.compile(",|;|\n|#|&|%|\\*|\\\\\\\\|/|//|\\?|-");

    public int Add(String nums) throws IllegalArgumentException{
        if(nums.equals("")) {
            return 0;
        }
        else if(nums.matches("(?i)A-Z")){
            throw new IllegalArgumentException("String contains letters instead of numbers and delimiters");
        }
        List<String> split = con.arrayToList(pattern, nums);
        return summarize(split);
    }

    public void parseStringToInt(List<String> split) throws NegativeArgumentException {
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
            throw new NegativeArgumentException("One or several numbers were negative. These numbers were invalid: " + negatives);
        }
    }

    public int summarize(List<String> split){
        int sum = 0;
        try {
            parseStringToInt(split);
            for (Integer integer : list) {
                int temp = sum;
                if (integer < 1000) {
                    sum = temp + integer;
                }
            }
        } catch (NegativeArgumentException e) {
            e.printStackTrace();
        }
        return sum;
    }
}
