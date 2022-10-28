package tree.lcp;

import java.util.*;

class LCP3 {
    static int N = 16;
    static int maxK =(int) Math.ceil(Math.log(N)/Math.log(2));
    static int[] depth = new int[N];
    static int[] parent = new int[N];
    static List<Integer>[] tree = new ArrayList[N];
    static boolean[] visited = new boolean[N];

    public static void main(String[] args) {
        dfs(1);
        System.out.println("parent " + Arrays.toString(parent));
        System.out.println("depth "+ Arrays.toString(depth));
    }
    static void dfs(int i){
        Queue<Integer> queue = new LinkedList<>();
        if(! visited[i]){
            visited[i] = true;
            queue.add(i);
            int level = 1;
            int count = 0;
            int nowSize = queue.size();
            while(! queue.isEmpty()){
                Integer node = queue.poll();
                for (int j : tree[node]) {
                    if(! visited[j]){
                        visited[j] = true;
                        parent[j] = node;
                        depth[node] = level;
                        queue.add(j);
                    }
                }
                count++;
                if(count == nowSize){
                    count = 0;
                    nowSize = queue.size();
                    level++;
                }
            }
        }
    }



    static {
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
