package tree.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Tree3 {
    static int N = 8;
    static List<Integer>[] tree = new List[N];
    static {
        for (int i = 0; i < tree.length; i++) {
            tree[i] = new ArrayList<>();
        }
        tree[1].add(6);
        tree[6].add(3);
        tree[3].add(5);
        tree[4].add(1);
        tree[2].add(4);
        tree[4].add(7);

        tree[6].add(1);
        tree[3].add(6);
        tree[5].add(3);
        tree[1].add(4);
        tree[4].add(2);
        tree[7].add(4);
    }
    static boolean[] visited = new boolean[N];
    static int[] parent = new int[N];


    public static void main(String[] args) {
        parent();
        System.out.println(Arrays.toString(parent));
    }

    static void parent(){
       parent[1] = 1;
        for (int i = 1; i < N; i++) {
            dfs(i);
        }

    }

    private static void dfs(Integer root) {
        visited[root] = true;
        for (int child : tree[root]) {
            if(! visited[child]){
                parent[child] = root;
                dfs(child);
            }
        }
    }
}
