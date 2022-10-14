package graph.water;

import java.util.*;

class Water3 {
    static int N = 3;
    static int[] limit = {8,9,10};
    static int[] now = {0,0,10};
    static int total = 10;
    static boolean[][][] check = new boolean[201][201][201];
    static Set<Integer> answer = new TreeSet<>();

    public static void main(String[] args) {
        water();
        answer.forEach(a -> System.out.print(a + " "));
    }

    static void water(){
        Queue<FromTo> queue = new LinkedList<>();
        queue.add(new FromTo(2,0)); //c->a
        queue.add(new FromTo(2,1)); //c->b

        while(! queue.isEmpty()){
            FromTo fromto = queue.poll();
            if(now[0] == 0){
                answer.add(now[2]);
            }

            now[fromto.to] += now[fromto.from];
            now[fromto.from] = 0;
            if(limit[fromto.to] < now[fromto.to]){
                now[fromto.from] = now[fromto.to] - limit[fromto.to];
                now[fromto.to] = limit[fromto.to];
            }

            int elseNode = 3 - fromto.from - fromto.to;
            System.out.println(Arrays.toString(now));
            if(check[now[0]][now[1]][now[2]]){
                continue;
            }
            check[now[0]][now[1]][now[2]] = true;

            queue.add(new FromTo(fromto.to, fromto.from)); //1->2
            queue.add(new FromTo(fromto.to, elseNode)); //1->0
        }

    }
}
class FromTo {
    int from;
    int to;

    public FromTo(int from, int to) {
        this.from = from;
        this.to = to;
    }
}
