package search.bfs;

import java.util.*;

class Diameter2 {
    static List<List<Nodes>> tree = new ArrayList<>();
    static {
        tree.add(Collections.emptyList());
        tree.add(List.of(new Nodes(3,2)));
        tree.add(List.of(new Nodes(4,4)));
        tree.add(List.of(new Nodes(1,2), new Nodes(4,3)));
        tree.add(List.of(new Nodes(2,4),new Nodes(3,3), new Nodes(5,6)));
        tree.add(List.of(new Nodes(4,6)));
    }
    static int N = 6;
    static int[] distance = new int[N];
    static boolean[] visitied = new boolean[N];

    public static void main(String[] args) {
        diameter(2);
        System.out.println(Arrays.toString(distance));
    }
    static void diameter(int start){
        visitied[start] = true;
        distance[start] = 0;
        Queue<Nodes> queue = new LinkedList<>();
        queue.add(new Nodes(start, 0));
        while(! queue.isEmpty()){
            Nodes node = queue.poll();
            for(Nodes next : tree.get(node.idx)){
                if(! visitied[next.idx]){
                    visitied[next.idx] = true;
                    distance[next.idx] = node.value + next.value;
                    queue.add(new Nodes(next.idx, distance[next.idx]));
                }
            }
        }
    }
}
class Nodes{
    int idx;
    int value;

    public Nodes(int idx, int value) {
        this.idx = idx;
        this.value = value;
    }
}
