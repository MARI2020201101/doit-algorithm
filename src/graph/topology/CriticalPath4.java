package graph.topology;

import java.util.ArrayList;
import java.util.List;

class CriticalPath4 {
    static int N = 8;
    static int[] indegree = new int[N];
    static int[] critical = new int[N];
    static int route = 0;
    static List<List<Node>> arr = new ArrayList<>();
    static {
        for (int i = 0; i < N; i++) {
            arr.add(new ArrayList<>());
        }
        arr.get(2).add(new Node(1,4));
        arr.get(3).add(new Node(1,2));
        arr.get(4).add(new Node(1,3));
        arr.get(6).add(new Node(2,3));
        arr.get(7).add(new Node(2,5));
        arr.get(5).add(new Node(3,1));
        arr.get(6).add(new Node(4,4));
        arr.get(6).add(new Node(5,2));
        arr.get(7).add(new Node(6,5));
        indegree[2]++;
        indegree[3]++;
        indegree[4]++;
        indegree[6]++;
        indegree[7]++;
        indegree[5]++;
        indegree[6]++;
        indegree[6]++;
        indegree[7]++;
    }
}
class Node{
    int idx;
    int distance;

    public Node(int idx, int distance) {
        this.idx = idx;
        this.distance = distance;
    }
}
class Route{
    int count;
    int value;

    public Route(int count, int value) {
        this.count = count;
        this.value = value;
    }
}
