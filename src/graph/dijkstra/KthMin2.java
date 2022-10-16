package graph.dijkstra;

import java.util.*;

class KthMin2 {
    static int N = 6;
    static int[][] arr = {
            {0,0,0,0,0,0},
            {0,0,2,7,5,6},
            {0,0,0,4,2,0},
            {0,0,0,0,6,8},
            {0,0,0,0,0,0},
            {0,0,4,0,1,0}
    };
    static int K = 2;
    static Queue<MyNode>[] answer = new PriorityQueue[N];
    static {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(arr[i][j]==0)arr[i][j]=Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < N; i++) {
            answer[i] = new PriorityQueue<>(K, Comparator.comparingInt(o -> o.cost));
        }
    }

    public static void main(String[] args) {
        kth();
        System.out.println(Arrays.toString(answer));
    }
    static void kth(){
        answer[1].offer(new MyNode(1, 0));
        Queue<MyNode> queue = new LinkedList<>();
        queue.offer(new MyNode(1,0));
        while(! queue.isEmpty()){
            MyNode i = queue.poll();
            for (int j = 1; j < N; j++) {
                if(arr[i.i][j] != Integer.MAX_VALUE){
                    if(answer[j].size() < K ) {
                        answer[j].offer(new MyNode(j, i.cost + arr[i.i][j]));
                        queue.offer(new MyNode(j, i.cost + arr[i.i][j]));
                    }else if(answer[j].peek()!=null
                            && answer[j].peek().cost > i.cost + arr[i.i][j] ){
                        answer[j].poll();
                        answer[j].offer(new MyNode(j, i.cost + arr[i.i][j]));
                        queue.offer(new MyNode(j, i.cost + arr[i.i][j]));
                    }

                }
            }
        }

    }
}
class MyNode {
    int i;
    int cost;

    @Override
    public String toString() {
        return "MyNode{" +
                "i=" + i +
                ", cost=" + cost +
                '}';
    }

    public MyNode(int i, int cost) {
        this.i = i;
        this.cost = cost;
    }
}
