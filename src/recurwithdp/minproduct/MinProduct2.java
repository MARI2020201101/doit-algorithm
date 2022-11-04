package recurwithdp.minproduct;

class MinProduct2 {
    public static void main(String[] args) {
        System.out.println(minProduct(7,11));
    }
    static int minProduct(int a, int b){
        int smaller = Math.min(a, b);
        int bigger = Math.max(a, b);
        return __minProduct(smaller, bigger);
    }

    private static int __minProduct(int smaller, int bigger) {
        if(smaller == 0){
            return 0;
        }
        if(smaller == 1){
            return bigger;
        }
        int x = smaller;
        x>>=1;
        int leftHalf = __minProduct(x , bigger);
        int rightHalf = leftHalf;
        if(smaller%2 == 1){
            rightHalf += bigger;
        }
        return leftHalf + rightHalf;
    }
}
