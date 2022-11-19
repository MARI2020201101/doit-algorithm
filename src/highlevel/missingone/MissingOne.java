package highlevel.missingone;

import java.math.BigInteger;

class MissingOne {
    static int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,16,17,18,19,20};

    public static void main(String[] args) {
        System.out.println(missingOne(fullN(arr,20), arr));
    }
    static BigInteger fullN(int[] arr, int n){
        BigInteger nFac = new BigInteger("1");
        for (int i = 1; i <= n; i++) {
            nFac = nFac.multiply(new BigInteger(String.valueOf(i)));
        }
        return nFac;
    }
    static BigInteger missingOne(BigInteger fullN, int[] arr){
        BigInteger nFac = new BigInteger("1");
        for (int i = 0; i < arr.length; i++) {
            BigInteger num = new BigInteger(String.valueOf(arr[i]));
            nFac = nFac.multiply(num);
        }
        return fullN.divide(nFac);
    }
}
