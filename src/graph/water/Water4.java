package graph.water;

import java.util.*;

class Water4 {
    static int N = 3;
    static boolean visited[][] = new boolean[201][201];
    static Set<Integer> answer = new TreeSet<>();
    static int[] limit = {8,9,10};
    static int[] from = {0,0,1,1,2,2};
    static int[] to = {1,2,0,2,0,1};
    static int total = 10;
    static int[] now = {0,0,10};

    public static void main(String[] args) {
        water();
        answer.forEach(System.out::println);
    }
    static void water(){
        Queue<AB> queue = new LinkedList<>();
        queue.add(new AB(0,0));

        while (! queue.isEmpty()){
            AB ab = queue.poll();
            int A = ab.a;
            int B = ab.b;
            int C = total - A - B;
            for(int i = 0; i< from.length ; i++){
                int[] next = {A, B, C}; //water 양
                next[to[i]] += next[from[i]];
                next[from[i]] = 0;

                if(limit[to[i]] < next[to[i]]){
                    next[from[i]] = next[to[i]] - limit[to[i]];
                    next[to[i]] = limit[to[i]];
                }

                if(visited[next[0]][next[1]]){
                    continue;
                }
                visited[next[0]][next[1]] = true;
                if(next[0]==0){
                    answer.add(next[2]);
                }
                System.out.println(Arrays.toString(next));
                queue.add(new AB(next[0], next[1]));
            }
        }
    }

}
class AB {
    int a ;
    int b ;

    public AB(int a, int b) {
        this.a = a;
        this.b = b;
    }
}
