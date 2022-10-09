package algebra;

import java.util.ArrayList;
import java.util.List;

class Eratosthenes {
    public static void main(String[] args) {
        prime(50);
    }
    static void prime(int n){
        int[] numbers = new int[n+1];
        List<Integer> primes = new ArrayList<>();
        primes.add(2);
        for (int i = 3; i < numbers.length; i+=2) {
            int j;
            for (j = 0; j < primes.size(); j++) {
                if(i%primes.get(j)==0) break;
            }
            if(j==primes.size()) primes.add(i);
        }
        primes.forEach(p-> System.out.print(p + ","));
    }
}
