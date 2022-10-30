package combination.permutationorder;

import java.util.Arrays;

class KthPermutation {
    public static void main(String[] args) {
        init(factorial);
        kthPermutation(solve, 3);
        Arrays.fill(visited,false);
        kthPermutation(solve,12);
    }
    static int N = 4;
    static int[] solve = new int[N+1];
    static boolean[] visited = new boolean[N+1];
    static int[] factorial = new int[N+1];
    static void init(int[] factorial){
        factorial[0] = 1;
        for (int i = 1; i <= N; i++) {
            factorial[i] = factorial[i-1]*i;
        }
    }
    static int[] kthPermutation(int[] solve, int k){
        for (int i = 0; i < N; i++) {
            for (int j = 1; j <= N; j++) {
                if(visited[j]) continue;
                if(factorial[N-i-1] < k){
                    k-=factorial[N-i-1];
                }else{
                    visited[j] = true;
                    solve[i] = j;
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(solve));
        return solve;
    }
}
