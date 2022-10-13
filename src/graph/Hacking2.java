package graph;

import java.awt.desktop.QuitResponse;
import java.util.*;

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
        hacking();
    }
    static int[] trusted = new int[N];
    static void hacking(){
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < arr.length; i++) {
            for(Integer node : arr[i]){
                trusted[node] += 1;
                queue.add(node);
            }
        }
        while(! queue.isEmpty()){
            Integer node = queue.poll();
            for(Integer next : arr[node]){
                trusted[next] += 1;
                queue.add(next);
            }
        }
        System.out.println(Arrays.toString(trusted));
    }
}
