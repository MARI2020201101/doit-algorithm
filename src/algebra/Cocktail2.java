package algebra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Cocktail2 {
    static int N = 4;
    static List<List<Node>> nodes = new ArrayList<>();
    static {
        nodes.add(List.of(new Node(1,9,3), new Node(3,5,7)));
        nodes.add(List.of(new Node(0,3,9)));
        nodes.add(List.of(new Node(3,6,8)));
        nodes.add(List.of(new Node(0,7,5), new Node(2,8,6)));
    }
    static boolean[] lcmed = new boolean[N];
    static int lcm = 1;
    static boolean[] visited = new boolean[N];
    static int[] ratio = new int[N];

    public static void main(String[] args) {
        lcm();
        ratio();
        System.out.println(Arrays.toString(ratio));
        // [7560, 840, 1890, 3528]
        System.out.println(gcd(840, gcd(2520, gcd(2646,3528))));

        for (int i = 0; i < ratio.length; i++) {
            System.out.print((ratio[i] / 42 )+" ");
        }

    }

    static void ratio(){
        for (int i = 0; i < nodes.size(); i++) {
            for (Node node: nodes.get(i)){
                dfs(i, node);
            }
        }
    }

    private static void dfs(int i, Node node) {
        if(! visited[i]){
            visited[i] = true;
            ratio[i] = lcm * node.p / node.q;
        }
    }

    static void lcm(){
        for (int i = 0; i < nodes.size(); i++) {
            for(Node node : nodes.get(i)){
                if(! lcmed[node.b]){
                    lcmed[node.b]=true;
                    int tmp = node.p * node.q / gcd(node.p, node.q);
                    lcm = tmp * lcm / gcd(tmp, lcm);
                }
            }
        }
        System.out.println("lcm="+ lcm);
    }

    static int gcd(int n, int m){
        while(m!=0 && n!=0) {
            if(n < m){
                int swap = m;
                m = n;
                n = swap;
            }
            int tmp = m;
            m = n%m;
            n = tmp;
        }
        return Math.max(n,m);
    }
}
