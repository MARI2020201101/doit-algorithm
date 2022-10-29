package tree.lcp.kn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class LCA {
    static int N = 16;
    static int K = (int) Math.ceil(Math.log(N)/Math.log(2));
    static int[][] parent = new int[K][N];
    static int[] depth = new int[N];
    static List<Integer>[] tree = new ArrayList[N];
    public static void main(String[] args) {
        parent[0][1]=0;
        dfs(1,1);
        kthParent();
        print(parent);
        System.out.println("depth "+ Arrays.toString(depth));
        lca(6,11);
        lca(10,9);
        lca(2,6);
        lca(7,6);
        lca(8,13);
        lca(8,15);
    }
    static int lca(int a, int b){
        int tmp = a;
        if(a > b){
            a = b ;
            b = tmp;
        }
        int node = depth[a] > depth[b] ? a : b ;
        int shorter = Math.min(depth[a], depth[b]);
        int longer = Math.max(depth[a], depth[b]);
        int k = 0;
        while(shorter < longer){
            System.out.println(String.format("shorter=%d, longer=%d, node=%d, k=%d",shorter,longer,node,k));
            node = parent[k++][node];
            longer/=2;
        }
        System.out.println("----");
        return 0;
    }
    static void kthParent(){
        for (int i = 2; i < N; i++) {
            for (int k = 1; k < K; k++) {
                parent[k][i] = parent[k-1][parent[k-1][i]];
            }
        }
    }
    static void dfs(int i, int count){
        for(int j : tree[i]){
            if(parent[0][j]==-1){
                parent[0][j] = i;
                depth[j]=count++;
                dfs(j,count);
            }
        }

    }
    static void print(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] +" ");
            }
            System.out.println();
        }
    }
    static {
        for (int i = 0; i < tree.length; i++) {
            tree[i] = new ArrayList<>();
        }
        for(int i = 0; i < N ;i ++){
            parent[0][i]=-1;
        }
        tree[1].add(2);
        tree[1].add(3);
        tree[2].add(4);
        tree[3].add(7);
        tree[6].add(2);
        tree[3].add(8);
        tree[4].add(9);
        tree[2].add(5);
        tree[5].add(11);
        tree[7].add(13);
        tree[10].add(4);
        tree[11].add(15);
        tree[12].add(5);
        tree[14].add(7);

        tree[2].add(1);
        tree[3].add(1);
        tree[4].add(2);
        tree[7].add(3);
        tree[2].add(6);
        tree[8].add(3);
        tree[9].add(4);
        tree[5].add(2);
        tree[11].add(5);
        tree[13].add(7);
        tree[4].add(10);
        tree[15].add(11);
        tree[5].add(12);
        tree[7].add(14);
    }
}
