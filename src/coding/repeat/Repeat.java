package coding.repeat;

import java.util.HashMap;
import java.util.Map;

class Repeat {
    public static void main(String[] args) {
        repeat();
    }
    static void repeat(){
        Map<int[], Double> map = new HashMap<>();
        for (int a = 1; a < 100; a++) {
            for (int b = 1; b < 100; b++) {
                double a3 = Math.pow(a, 3);
                double b3 = Math.pow(b, 3);
                map.put(new int[]{a,b}, a3+b3);
            }
        }
        map.forEach((k,v)-> System.out.println(k[0]+","+k[1]+" = "+v));
    }
}
