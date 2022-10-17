package graph.bellmanford;

import java.util.Arrays;

class TimeMachine3 {
    static int N = 4;
    static int M = 4;
    static int[] answer = new int[N];
    static Edge[] edges = {
            new Edge(1,2,4),
            new Edge(1,3,3),
            new Edge(2,3,-4),
            new Edge(3,1,-2),
    };
    static {
        Arrays.fill(answer, Integer.MAX_VALUE);
    }

    public static void main(String[] args) {
        solve();
    }
    static void solve(){
        answer[1] = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < M; j++) {
                Edge edge = edges[j];
                if(answer[edge.from] == Integer.MAX_VALUE) continue;
                else if(answer[edge.to] > answer[edge.from] + edge.cost){
                    answer[edge.to] = answer[edge.from] + edge.cost;
                    if(i > 0) {
                        answer[edge.to] = Integer.MIN_VALUE;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(answer));
    }
}
