package graph.unionfind;

import java.util.Arrays;

class RecurUnionFind {
    static int[] parent = {0,1,2,3,4,5,6,7};
    static int[] arr ={0,1,1,2,3,4,5};

    public static void main(String[] args) {
        union(1,4);
        System.out.println(Arrays.toString(arr));
    }
    static void union(int a, int b){
        int idxB = b;
        int rootA = find(a);
        while(arr[idxB] != idxB){
            int parentB = arr[idxB];
            arr[idxB] = rootA;
            idxB = parentB;
        }
    }
    static int find(int a){
        if(arr[a] == a) return a;
        return find(arr[a]);
    }
}
