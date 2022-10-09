package algebra;

import java.util.ArrayList;
import java.util.List;

class AlmostPrime {
    public static void main(String[] args) {
        System.out.println(prime(1000));
    }
    static int prime(int n){
        int limit = (int) Math.sqrt(n) + 1;
        int[] numbers = new int[limit];
        List<Integer> primes = new ArrayList<>();
        primes.add(2);
        for (int i = 3; i < numbers.length; i+=2) {
            int j;
            for (j = 0; j < primes.size(); j++) {
                if(i%primes.get(j)==0) break;
            }
            if(j==primes.size()) primes.add(i);
        }
        int count = 0;

        for (int i = 0; i < primes.size(); i++) {
            for (int pow = 2; ; pow++) {
                if(Math.pow(primes.get(i),pow) <= n) count++;
                else break;
            }
        }

        return count;
    }
}
