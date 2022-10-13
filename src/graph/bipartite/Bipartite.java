package graph.bipartite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

class Bipartite {
    static int N = 5;
    static List<Integer>[] arr = new ArrayList[N];
    static AtomicInteger ai = new AtomicInteger(0);
    static{
        Arrays.setAll(arr, a -> new ArrayList<Integer>());
        arr[1].add(2);
        arr[2].add(3);
        arr[3].add(4);
        arr[4].add(2);
    }
    static String[] value = new String[N];
    static boolean[] visited = new boolean[N];
    public static void main(String[] args) {
        isBipartite();
        System.out.println(Arrays.toString(value));
    }
    static void isBipartite(){
        for (int i = 1; i < arr.length; i++) {
            for (Integer node : arr[i]){
                value[node] = (value[node] == null) ? "A" : "B";
                _dfs(node);
            }
        }
    }

    private static void _dfs(Integer i) {
        System.out.println(String.format("[%d]: dfs %d",ai.getAndAdd(1),i));
        for (Integer node : arr[i]){
            if(! visited[node]){
                visited[node] = true;
                value[node] = value[i].equals("A") ? "B" : "A";
                _dfs(node);
            }
            else {
                if(value[node].equals(value[i])) {
                    System.out.println("NO");
                    return;
                }
            }
        }
    }
}
