package graph.unionfind;

import java.util.Arrays;

class UnionFind3 {

    static int[] parent = {0,1,2,3,4,5,6,7};
    static int[] arr ={0,1,1,2,3,4,5};

    public static void main(String[] args) {
        union(1,4);
        System.out.println(Arrays.toString(arr));
    }
    static void union(int a, int b){
        int A = find(a);
        int B = find(b);
        if(A != B){
            arr[b] = A;
//            find(b);
        }
    }
    static int find(int a){
        if(arr[a] == a) return a;
        return arr[a] = find(arr[a]);
    }
}
