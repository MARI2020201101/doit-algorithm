package graph.bipartite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

class Bipartite2 {
    static int N = 5;
    static List<Integer>[] arr = new ArrayList[N];
    static{
        Arrays.setAll(arr, a -> new ArrayList<Integer>());
        arr[1].add(2);
        arr[2].add(3);
        arr[3].add(4);
        arr[4].add(2);
    }
    static int[] value = new int[N];
    static boolean[] visited = new boolean[N];
    static boolean isBipartite = true;

    public static void main(String[] args) {
        for (int i = 1; i < arr.length; i++) {
            bipartite(i);
            if(! isBipartite){
                System.out.println("NO");
                return;
            }else{
                System.out.println("YES");
            }
            Arrays.fill(visited, false);
        }
    }
    static void bipartite(int v){
        visited[v] = true;
        value[v]=2;
        bfs(v);
    }

    private static void bfs(int v) {
        for(Integer i : arr[v]){
            if(! visited[i]){
                visited[i] = true;
                value[i] = (value[v]+1)%2;
                bfs(i);
            }else{
                if(value[i]==value[v]) {
                    isBipartite = false;
                }
            }
        }
    }
}
