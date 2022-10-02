package datastructure.average;

import java.util.Arrays;


class Average {
    public static void main(String[] args) {
        System.out.println(average(3, "40 80 60"));
    }
    static double average(int n, String str){
        double [] scores = Arrays
                .stream(str.split(" "))
                .mapToDouble(Double::parseDouble).toArray();
        double max = scores[0];
        for (int i = 1; i < scores.length; i++) {
            max=Math.max(max, scores[i]);
        }

        double finalMax = max;
        return Arrays.stream(scores).map(s -> s / finalMax * 100).average().getAsDouble();
    }
}
