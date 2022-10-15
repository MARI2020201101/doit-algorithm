package graph.unionfind;

import java.util.Arrays;

class Trip2 {
    static int[][] city = {
            {0,1,0},
            {1,0,1},
            {0,1,0}
    };
    static int[] trip = {0,1,2};
    static int[] parent = {0,1,2};

    public static void main(String[] args) {
        trip();
    }
    static void trip(){
        city();
        int i;
        for (i = 1; i < trip.length; i++) {
            if(find(trip[i-1]) != find(trip[i])) break;
        }
        if(i==trip.length) {
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
        System.out.println(Arrays.toString(parent));
    }
    static void city(){
        for (int i = 0; i < city.length; i++) {
            for (int j = 0; j < city[i].length; j++) {
                if(city[i][j]==1) union(i,j);
            }
        }
    }
    static void union(int a, int b){
        int A = find(a);
        int B = find(b);
        if(A!=B){
            parent[b] = A;
        }
    }
    static int find(int a){
        if(parent[a]==a) return a;
        return parent[a] = find(parent[a]);
    }
}
