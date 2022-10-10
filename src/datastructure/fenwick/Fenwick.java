package datastructure.fenwick;

import java.util.Arrays;

class Fenwick {
    static int[] arr = {0,3,1,5,8,12,9,7,13,0,3,1,4,9,0,11,5};
    static int[] tree = new int[arr.length];

    public static void main(String[] args) {
        createFenwickTree();
        System.out.println(subsum(10,5));
        int result = 0;
        for (int i = 6; i <=10 ; i++) {
            result+=arr[i];
        }
        System.out.println("result="+result);
    }
    static int subsum(int from, int to){
        return _subsum(from) - _subsum(to);
    }
    static int _subsum(int n){
        int result =0;
        while(n>0){
            result+=tree[n];
            n-=lsb(n);
        }
        return result;
    }
    static void createFenwickTree(){
        for (int i = 1; i < tree.length; i++) {
            for (int j = i; j >= i-lsb(i) ; j--) {
                tree[i] += arr[j];
            }
        }
        System.out.println(Arrays.toString(tree));
    }
    static int lsb(int n){
        return n & (~n+1);
    }
}
