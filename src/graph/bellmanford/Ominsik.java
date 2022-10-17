package graph.bellmanford;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Ominsik {
    static int N = 5;
    static List<Node>[] nodes = new ArrayList[N];
    static int[] value = {0,10,10,110,10};

    static{
        for (int i = 0; i < N; i++) {
            nodes[i] = new ArrayList<>();
        }
        nodes[0].add(new Node(1, 10));
        nodes[1].add(new Node(2, 10));
        nodes[2].add(new Node(3, 10));
        nodes[3].add(new Node(1, 10));
        nodes[2].add(new Node(4, 10));
    }
    static int maxVal =  Integer.MIN_VALUE;

    public static void main(String[] args) {
        solve();
        System.out.println(maxVal);
    }
    static void solve(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0,Integer.MIN_VALUE));
        while (! queue.isEmpty()){
            Node node = queue.poll();
            for(Node next : nodes[node.idx]){
                if(node.cost < value[next.idx] - next.cost){
                    maxVal = Math.max(maxVal, value[next.idx] - next.cost);
                    queue.offer(new Node(next.idx , value[next.idx] - next.cost));
                }
            }

        }
    }
}
class Node{
    int idx;
    int cost;

    public Node(int idx, int cost) {
        this.idx = idx;
        this.cost = cost;
    }
}