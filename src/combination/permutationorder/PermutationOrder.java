package combination.permutationorder;

import java.util.Arrays;

class PermutationOrder {
    static int N = 4;
    static int[] number = new int[N+1];
    static int[] permutation = new int[N+1];

    public static void main(String[] args) {
        init();
    }
    static void init(){
        for(int i = 0 ; i <=N ;i++){
            number[i]=i;
        }
        for(int i = 1;i <=N ; i++){
            permutation[i]=N-i+1;
        }
        for(int i = 2; i <=N ; i++){
            permutation[i] *= permutation[i-1];
        }

        System.out.println(Arrays.toString(number));
    }
    static void printOrder(int[] permutation, int k){
        int idx = 0;
        while(permutation[idx] < k){
            idx++;
        }
        int first = number[idx];
    }
}
