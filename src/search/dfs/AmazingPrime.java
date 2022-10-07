package search.dfs;

class AmazingPrime {
    static int N = 4;

    public static void main(String[] args) {
        int[] primeOne = {2,3,5,7};
        for (int i = 0; i < primeOne.length; i++) {
            search(primeOne[i],1);
        }
    }
    static int search(int number, int n){
        if(n==4){
            System.out.println(number);
            return number;
        }
        for (int i = 1; i < 10; i++) {
            int target = Integer.parseInt(String.valueOf(number) + i + "");
            if(isPrime(target)) search(target, n+1);
        }
        return number;
    }

    private static boolean isPrime(int target) {
        double sqrt = Math.sqrt(target);

        if(target%2==0) return false;
        for (int i = 3; i <= sqrt; i+=2) {
            if(target%i==0) return false;
        }
        return true;
    }
}
