package tree.lcp;

import java.util.*;

class LCP2 {
    static int N = 16;
    static int[] depth = new int[N];
    static int[] parent = new int[N];
    static List<Integer>[] tree = new ArrayList[N];

    public static void main(String[] args) {
        lcp();
        System.out.println("parent " + Arrays.toString(parent));
        System.out.println("depth "+ Arrays.toString(depth));
    }

    static void lcp(){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 1});
        while(! queue.isEmpty()){
            int[] node = queue.poll();
            for (int child: tree[node[0]]) {
                parent[child] = node[0];
                depth[child] = node[1];
                queue.add(new int[]{child, ++node[1]});
            }
        }
    }
    static {
        for (int i = 0; i < tree.length; i++) {
            tree[i] = new ArrayList<>();
        }
        tree[1].add(2);
        tree[1].add(3);
        tree[2].add(4);
        tree[2].add(5);
        tree[3].add(7);
        tree[3].add(8);
        tree[4].add(9);
        tree[5].add(11);
        tree[6].add(2);
        tree[7].add(13);
        tree[10].add(4);
        tree[11].add(15);
        tree[12].add(5);
        tree[14].add(7);
    }
}
