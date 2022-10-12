package graph;

import java.util.ArrayList;
import java.util.List;

class Hacking2 {

    static int N = 6;
    static List<Integer>[] arr = new ArrayList[N];
    static {
        for (int i = 0; i < N; i++) {
            arr[i] = new ArrayList<>();
        }
        arr[3].add(1);
        arr[3].add(2);
        arr[4].add(3);
        arr[5].add(3);
    }

    public static void main(String[] args) {
        System.out.println(arr);
    }
}
