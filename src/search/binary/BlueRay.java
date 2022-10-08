package search.binary;

import java.util.Arrays;

class BlueRay {
    static int[] arr = {1,2,3,4,5,6,7,8,9};
    static int N = 3;

    public static void main(String[] args) {
        blueray(N);
    }
    static void blueray(int n){
        int sum = Arrays.stream(arr).sum();
        int blueray = sum;
        while(sum <= blueray){
            int optimal = blueray * n;
            if(optimal < sum){
                blueray = (arr[0] + optimal)/2;
            }
        }
        System.out.println(blueray);
    }
}
