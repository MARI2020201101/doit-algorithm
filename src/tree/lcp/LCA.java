package tree.lcp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LCA {
    static int N = 16;
    static int[] depth = new int[N];
    static int[] parent = new int[N];
    static List<Integer>[] tree = new ArrayList[N];
    static boolean[] visited = new boolean[N];

    public static void main(String[] args) {
        dfs(1,0);
        System.out.println("parent " + Arrays.toString(parent));
        System.out.println("depth "+ Arrays.toString(depth));
    }
    static void dfs(int i, int count){
        depth[i] = count++;
        for (int j : tree[i]) {
            if(depth[j]==-1){
                parent[j]=i;
                depth[j]=count;
                dfs(j, count);
            }
        }
    }
    static {
        for (int i = 0; i < depth.length; i++) {
            depth[i] = -1;
        }
        for (int i = 0; i < tree.length; i++) {
            tree[i] = new ArrayList<>();
        }
        tree[1].add(2);
        tree[1].add(3);
        tree[2].add(1);
        tree[3].add(1);
        tree[2].add(4);
        tree[2].add(5);
        tree[4].add(2);
        tree[5].add(2);
        tree[3].add(7);
        tree[3].add(8);
        tree[7].add(3);
        tree[8].add(3);
        tree[4].add(9);
        tree[9].add(4);
        tree[5].add(11);
        tree[11].add(5);
        tree[6].add(2);
        tree[2].add(6);
        tree[7].add(13);
        tree[13].add(7);
        tree[10].add(4);
        tree[4].add(10);
        tree[11].add(15);
        tree[15].add(11);
        tree[12].add(5);
        tree[5].add(12);
        tree[14].add(7);
        tree[7].add(14);
    }
}
