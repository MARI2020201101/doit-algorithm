package graph.unionfind;

import java.util.Arrays;

class DontWannabeLier2 {
    static int[] parent = {0,1,2,3,4,5,6,7,8,9,10};
    static int count = 0;

    public static void main(String[] args) {
        lier(4,1,2,3,4);
        count(2,1,5);
        count(2,2,6);
        count(1,7);
        count(1,8);
        count(2,7,8);
        count(1,9);
        count(1,10);
        count(2,3,10);
        count(1,4);
        System.out.println("count= "+ count);
    }
    static void count(int ... party){
        if(party[0]==1){
           if(parent[1] != find(party[1])){
               count++;
           }
        }
        else{
            boolean sameGroup = false;
            int len = party[0];
            for (int i = 1; i <= len; i++) {
                if(parent[1] == find(party[i])) sameGroup = true;
            }
            if(! sameGroup) count++;
        }
    }
    static void lier(int ... know){
        int len = know[0];
        int first = know[1];
        for (int i = 2; i <= len; i++) {
           union(first, know[i]);
        }
        System.out.println(Arrays.toString(parent));
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
