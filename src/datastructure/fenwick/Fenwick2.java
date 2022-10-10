package datastructure.fenwick;

import java.util.Arrays;

class Fenwick2 {
    static int[] arr = {0,3,1,5,8,12,9,7,13,0,3,1,4,9,0,11,5};
    static int[] tree = new int[arr.length];

    public static void main(String[] args) {
        createFenwick();
        System.out.println(subsum(2,9));
    }
    public static int subsum(int from, int to){
        return sum(to) - sum(from-1);
    }
    public static int sum(int n){
        int result = 0;
        while(n>0){
            result+=tree[n];
            n-=lsb(n);
        }
        return result;
    }
    public static void createFenwick(){
        tree = arr.clone();

        for (int i = 1; i < tree.length; i++) {
            int parent = i + lsb(i);
            if(parent < tree.length){
                tree[parent] += tree[i];
                System.out.println(String.format("tree[%d] += tree[%d]", parent,i));
            }
        }
        System.out.println(Arrays.toString(tree));
    }
    public static int lsb(int n){
        return n & (-n);
    }
}
