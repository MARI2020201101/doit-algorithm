package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Hacking {
    static List<List<Integer>> arr = new ArrayList<>();
    static {
        arr.add(Collections.emptyList());
        arr.add(List.of(3));
        arr.add(List.of(3));
        arr.add(List.of(4,5));
        arr.add(Collections.emptyList());
        arr.add(Collections.emptyList());
    }

    static int N = 6;
    static boolean visited[] = new boolean[N];
    static int[] trust = new int[N];

    public static void main(String[] args) {
        dfs();
        System.out.println(Arrays.toString(trust));
    }
    static void dfs(){
        for (int i = 1; i < arr.size(); i++) {
            _dfs(i);
        }
    }

    private static void _dfs(Integer from) {
        for (Integer to : arr.get(from)) {
//            if (! visited[to]) {
//                visited[to] = true;
                trust[from]++;
                _dfs(to);
//            }
        }
    }
}
