package algebra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Cocktail4 {
    static int N = 4;
    static List<List<Node>> nodes = new ArrayList<>();
    static int[] ratio = new int[N];
    static {
        nodes.add(List.of(new Node(1,9,3), new Node(3,5,7)));
        nodes.add(List.of(new Node(0,3,9)));
        nodes.add(List.of(new Node(3,6,8)));
        nodes.add(List.of(new Node(0,7,5), new Node(2,8,6)));
    }
    static boolean[] lcmed = new boolean[N];
    static int lcm = 1;

    static boolean[] visited = new boolean[N];

    public static void main(String[] args) {
        ratio[0]=lcm();
        dfs(0);
        calculate(ratio);
    }

    static void calculate(int[] ratio){
        int totalGcd = totalGcd(ratio);
        for (int i = 0; i < ratio.length; i++) {
            System.out.print(ratio[i]/totalGcd + " ");
        }
    }
    static int totalGcd(int[] ratio){
        int gcd = ratio[0];
        for (int i = 1; i < ratio.length; i++) {
            gcd = gcd(gcd, ratio[i]);
        }
        return gcd;
    }
    static void dfs(int i) {
        for (Node node: nodes.get(i)) {
            if (!visited[node.b]) {
                visited[node.b] = true;
                ratio[node.b] = ratio[i] * node.q / node.p;
                dfs(node.b);
            }
        }
    }

    static int lcm(){
        for (int i = 0; i < nodes.size(); i++) {
            for(Node node : nodes.get(i)){
                if(! lcmed[node.b]){
                    lcmed[node.b]=true;
                    int tmp = node.p * node.q / gcd(node.p, node.q);
                    lcm = tmp * lcm / gcd(tmp, lcm);
                }
            }
        }
        return lcm;
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
