package tree.tree;

import java.util.*;

class Tree {
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
    }
    static int[] parent = new int[N*100];


    public static void main(String[] args) {
        parent();
        System.out.println(Arrays.toString(parent));
    }

    static void parent(){
        parent[0]=1;
        int root = 1;
        int idx = 1;
        while(idx < N){
            for(Integer child : tree[root]){
                if(parent[root*2+1]==0){
                    parent[root*2+1] = child;
                }else {
                    parent[root*2+2] = child;
                }
                root = child;
                idx++;
            }
        }

    }
}
