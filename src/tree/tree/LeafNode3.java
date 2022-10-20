package tree.tree;

import java.util.ArrayList;
import java.util.List;

class LeafNode3 {
    static int N = 9;
    static List<Integer>[] tree = new ArrayList[N];
    static int target = 4;
    static boolean[] visited= new boolean[N];
    static int leafNodeCount = 0;

    static {
        for (int i = 0; i <N ; i ++){
            tree[i] = new ArrayList<>();
        }
        tree[1].add(0);
        tree[2].add(0);
        tree[3].add(2);
        tree[4].add(2);
        tree[5].add(4);
        tree[6].add(4);
        tree[7].add(6);
        tree[8].add(6);

        tree[0].add(1);
        tree[0].add(2);
        tree[2].add(3);
        tree[2].add(4);
        tree[4].add(5);
        tree[4].add(6);
        tree[6].add(7);
        tree[6].add(8);
    }
    public static void main(String[] args) {
        dfs(0);
        System.out.println("leafNode Count = "+ leafNodeCount);
    }
    static void dfs(int root){
        visited[root] = true;
        int cnt = 0;

        for (Integer child: tree[root]) {
            if(! visited[child]){
                visited[child] = true;
                if(child != target) {
                    cnt++;
                    dfs(child);
                }
            }
        }
        if(cnt == 0) leafNodeCount++;
    }
}
