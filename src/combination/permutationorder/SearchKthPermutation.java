package combination.permutationorder;

import java.util.Arrays;

class SearchKthPermutation {
    static int N = 4;
    static int[] permutation = {1,3,2,4};
    static boolean[] visited = new boolean[N+1];
    static int[] factorial = new int[N+1];

    public static void main(String[] args) {
        init(factorial);
        System.out.println(search(new int[]{2,4,3,1}));
        Arrays.fill(visited,false);
        System.out.println(search(permutation));
    }
    static void init(int[] factorial){
        factorial[0] = 1;
        for (int i = 1; i <= N; i++) {
            factorial[i] = factorial[i-1]*i;
        }
    }
    static int search(int[] permutation){
        int k = 1;
        int idx = 1;
        for (int i = 0; i < permutation.length; i++) {
            int current = permutation[i];
            for (int j = 1; j <= N; j++) {
                if(visited[j]) continue;
                if(current == j){
                    visited[j]=true;
                    idx++;
                    break;
                }else if(current > j){
                    k += factorial[N-idx];
                }
            }
        }
        return k;
    }
}
