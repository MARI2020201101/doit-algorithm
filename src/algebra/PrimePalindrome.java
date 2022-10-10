package algebra;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class PrimePalindrome {
    public static void main(String[] args) {
        System.out.println(palindrome(prime(31)));
    }

    static List<String> prime(int n){
        int max = (int)Math.sqrt(1000000) + 1 ;
        int[] numbers = new int[max];
        List<Integer> primes = new ArrayList<>();
        primes.add(2);
        for (int i = 3; i < numbers.length; i+=2) {
            int j;
            for (j = 0; j < primes.size(); j++) {
                if(i%primes.get(j)==0) break;
            }
            if(j==primes.size()) primes.add(i);
        }
        return primes.stream()
                .filter(p -> p > n)
                .map(String::valueOf)
                .collect(Collectors.toList());
    }
    static int palindrome(List<String> primes){

        String s = primes.stream()
                .filter(p -> {
                    StringBuffer sb = new StringBuffer(p);
                    return sb.reverse().toString().equals(p);
                })
                .findFirst()
                .orElse("-1");
        return Integer.parseInt(s);
    }
}
