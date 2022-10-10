package algebra;

class EulersPhi2 {
    public static void main(String[] args) {
        System.out.println(eulersPhi(45));
    }
    static int eulersPhi(int n){
        int result = n;

        for (int p = 2; p <= Math.sqrt(n) ; p++) {
            if(n % p == 0){
                result -= n/p;
                System.out.println(String.format("result=%d, n=%d",result,n));
                while(n % p ==0){
                    n /= p;
                }
            }
        }
        if(n > 1){
            System.out.println(String.format("result=%d, n=%d",result,n));
            result -= result/n;
        }

        return result;
    }
}
