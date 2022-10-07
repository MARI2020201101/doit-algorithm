package search.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

class Friend {
    static int N = 5;
    static List<Integer>[] people = new ArrayList[N];
    static boolean[] visited = new boolean[N];
    static AtomicInteger count = new AtomicInteger(0);
    static {
        List<Integer> list0 = new ArrayList<>();
        list0.add(1);
        list0.add(3);
        List<Integer> list1 = new ArrayList<>();
        list0.add(0);
        list0.add(2);
        list0.add(4);
        List<Integer> list2 = new ArrayList<>();
        list0.add(1);
        list0.add(3);
        List<Integer> list3 = new ArrayList<>();
        list0.add(0);
        list0.add(2);
        List<Integer> list4 = new ArrayList<>();
        list0.add(1);
        people[0] = list0;
        people[1] = list1;
        people[2] = list2;
        people[3] = list3;
        people[4] = list4;
    }

    public static void main(String[] args) {
        dfs();
    }
    static void dfs(){
        for (int i = 0; i < N; i++) {
            _dfs(i);
        }
//        System.out.println(Arrays.toString(visited));
    }

    private static void _dfs(int v) {
        if(visited[v]) return;
        visited[v] = true;
        System.out.println(count.getAndAdd(1) + " : " +Arrays.toString(visited));
        for(Integer friend : people[v]){
            _dfs(friend);
        }
    }
}
