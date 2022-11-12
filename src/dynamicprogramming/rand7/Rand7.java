package dynamicprogramming.rand7;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class Rand7 {
    static Random random = new Random();

    public static void main(String[] args) {
        Map<Integer, Long> countMap = new HashMap<>();
        for (int i = 0; i < 7; i++) {
            countMap.put(i,0L);
        }
        for (int i = 0; i < 1000; i++) {
            countMap.computeIfPresent(rand7(), (k,v)->v+1);
        }
        countMap.forEach((k,v)-> System.out.println("["+k+"] : "+v));
    }
    static Integer rand7(){
        int r1 = 5 * rand5() + rand5() + rand5();
        if(r1 < 21){
            return r1%7;
        }
        return rand7();
    }

    static Integer rand5(){
        return random.nextInt(5);
    }
}
