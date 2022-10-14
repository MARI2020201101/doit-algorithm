package graph.water;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Water2 {
    static int N = 3;
    static int[] bucket = {8,9,10};
    static int[] water = {0,0,10};
    static List<Integer>[] nodes = new ArrayList[N];
    static {
        Arrays.setAll(nodes , n->new ArrayList<>());
        nodes[0].add(1);
        nodes[0].add(2);
        nodes[1].add(0);
        nodes[1].add(2);
        nodes[2].add(0);
        nodes[2].add(1);
    }

    public static void main(String[] args) {
        water();
    }

    static void water(){
        for(Integer node : nodes[2]){
            if(water[2] >= bucket[node]){
                water[node]=bucket[node];
                water[2] -= bucket[node];
            }else{
                water[node] = water[2];
                water[2] = 0;
            }
            System.out.println(String.format("A=%d, B=%d, C=%d", water[0],water[1],water[2]));
            dfs(node);
        }
    }

    private static void dfs(Integer i) {
        if(water[0]==0){
            System.out.println(String.format("water[2]=%d", water[2]));
            return;
        }

        for(Integer node : nodes[i]){
            if(water[i] >= bucket[node]){
                water[node] = bucket[node];
                water[i] -= bucket[node];
            }else{
                water[node] = water[i];
                water[i] = 0;
            }

            dfs(node);
        }

    }

}
