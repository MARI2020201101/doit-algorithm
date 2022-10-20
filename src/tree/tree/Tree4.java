package tree.tree;

import java.util.*;

class Tree4 {
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
        bfs();
        System.out.println(Arrays.toString(parent));
    }

   static void bfs(){
       Queue<Integer> queue = new LinkedList<>();
       queue.add(1);
       parent[1] = 1;
       while(! queue.isEmpty()){
           Integer node = queue.poll();
           for (int child : tree[node]) {
               if(parent[child]==0){
                   parent[child] = node;
                   queue.add(child);
               }
           }

       }
   }
}
