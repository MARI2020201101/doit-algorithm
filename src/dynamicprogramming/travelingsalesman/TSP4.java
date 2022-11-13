package dynamicprogramming.travelingsalesman;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TSP4 {
    static int N = 4;
    static int[][] arr = {
            {0,10,15,20},
            {5,0,9,10},
            {6,13,0,12},
            {8,8,9,0},
    };
    static int[] answer = new int[N];
    static boolean[] visited = new boolean[N];
    static Queue<Node> queue = new LinkedList<>();
    public static void main(String[] args) {
        Arrays.setAll(answer,a->Integer.MAX_VALUE);
        for (int i = 0; i < N; i++) {
            queue.add(new Node(1, i, 0, arr[i][i]));
        }
        bfs();
        System.out.println(Arrays.toString(answer));
    }

    static void bfs(){
        while(! queue.isEmpty()){
        Node node = queue.poll();
        if(node.idx > N){
            answer[node.root] = Math.min(answer[node.root],node.value);
        }
            for (int next = 0; next < N; next++) {
                if(! visited[next]){
                    visited[next] = true;
                    queue.add(new Node(node.idx+1, node.root, next, node.value + arr[node.next][next]));
                }
            }
        }
    }

    static void print(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] +" ");
            }
            System.out.println();
        }
    }
}
class Node{
    int idx;
    int root;
    int next;
    int value;

    public Node(int idx, int root, int next, int value) {
        this.idx = idx;
        this.root = root;
        this.next = next;
        this.value = value;
    }
}
