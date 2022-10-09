package greedy;

import java.util.Arrays;

class Bracket {
    static String expression = "100-40+50+74-30+29-45+43+11";

    public static void main(String[] args) {
        System.out.println(calculate(expression));
    }
    static int calculate(String expression){
        String[] exs = expression.split("-");
        System.out.println(Arrays.toString(exs));
        int result = 0;
        for(int i = 0; i< exs.length ; i++){
            String[] numbers = exs[i].split("\\+");
            int tmp=0;
            int j;
            for (j = 0; j < numbers.length; j++) {
                tmp+=Integer.parseInt(numbers[j]);
            }
            result = j==1? tmp : result-tmp;
        }
        return result;
    }
}
