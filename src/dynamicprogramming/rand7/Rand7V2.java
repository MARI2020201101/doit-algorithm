package dynamicprogramming.rand7;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Rand7V2 {
    static Random random = new Random();

    public static void main(String[] args) {
        Map<Integer, Long> countMap = new HashMap<>();
        for (int i = 0; i < 7; i++) {
            countMap.put(i,0L);
        }
        for (int i = 0; i < 100; i++) {
            countMap.computeIfPresent(rand7(), (k,v)->v+1);
        }
        countMap.forEach((k,v)-> System.out.println("["+k+"] : "+v));
    }
    static Integer rand7(){
        int r1 = 2 * rand5();
        int r2 = rand5();
        if(r2!=4){
            r2%=2;
            if(r1+r2 < 7){
                return r1+r2;
            }
        }
        return rand7();
    }
    static Integer rand5(){
        return random.nextInt(5);
    }
}
