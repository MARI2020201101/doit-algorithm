package algebra;

import java.util.Arrays;

class Cocktail {
    static int N = 4;
    static Node[] arr = new Node[N];
    static {
        arr[0]=new Node(1,9,3);
        arr[1]=null;
        arr[2]=new Node(3,6,8);
        arr[3]=new Node(0,7,5);
    }
    static int lcm = 1;
    static boolean[] visited = new boolean[N];
    static int[] ratio = new int[N];

    public static void main(String[] args) {
        lcm();
        ratio();
        System.out.println(Arrays.toString(ratio));
    }
    static void lcm(){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]!=null){
                lcm *= arr[i].p * arr[i].q / gcd(arr[i].p, arr[i].q);
            }
        }
        System.out.println("lcm="+lcm);
    }
    static void ratio(){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]!=null && !visited[i]){
                dfs(i, arr[i]);
            }
        }
    }

    private static void dfs(int i, Node node) {
        visited[i] = true;
        ratio[i] = lcm * node.p / node.q;
        if(arr[node.b]!=null && ! visited[node.b]){
            dfs(node.b, arr[node.b]);
        }
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
class Node {
    int b;
    int p;
    int q;
    public Node(int b, int p, int q) {
        this.b = b;
        this.p = p;
        this.q = q;
    }
}