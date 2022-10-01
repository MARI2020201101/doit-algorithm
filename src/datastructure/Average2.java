package datastructure;

import java.util.Arrays;

class Average2 {
    public static void main(String[] args) {
        System.out.println(average(3, "40 80 60"));
    }
    static double average(int n, String str){
        double max = Arrays
                .stream(str.split(" "))
                .mapToDouble(Double::parseDouble).max().getAsDouble();

        double sum = Arrays
                .stream(str.split(" "))
                .mapToDouble(Double::parseDouble).sum();

        return (sum/max*100)/n;

    }
}
