package graph.minimumspanningtree;

import java.util.PriorityQueue;
import java.util.Queue;

class Prim {
    static int N = 4;
    static Queue<Node>[] queue = new PriorityQueue[N];
    static int answer = 0;
    static int nodeCount = 0;

    public static void main(String[] args) {
        prim();
    }
    static void prim(){
        for (int i = 0; i < queue.length; i++) {
            queue[i] = new PriorityQueue<>();
        }
        queue[1].offer(new Node(2,1));
        queue[2].offer(new Node(3,2));
        queue[1].offer(new Node(3,3));
        int start = 1;
        nodeCount += 1;

        while(nodeCount < N-1){
            Node node = queue[start].poll();
            answer+=node.cost;
            nodeCount++;
            start = node.idx;
        }
        System.out.println("answer = "+ answer);
    }

}
class Node implements Comparable<Node>{
    int idx;
    int cost;

    public Node(int idx, int cost) {
        this.idx = idx;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}