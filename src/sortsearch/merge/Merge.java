package sortsearch.merge;

import java.lang.reflect.Array;
import java.util.Arrays;

class Merge {
    public static void main(String[] args) {
        int[] a = {1,4,9,10,22,33,46,77,79,99,0,0,0,0,0,0,0,0,0,0};
        int[] b = {2,5,6,10,21,32,39,67,89,100};
        int[] merge = merge(a, b, 9, 9);
        System.out.println(Arrays.toString(merge));
    }
    static int[] merge(int[] a, int[] b, int lastA, int lastB){
        int idx = a.length-1;
        while(lastA>=0 && lastB>=0){
            if(a[lastA] > b[lastB]){
                a[idx--] = a[lastA--];
            }else{
                a[idx--] = b[lastB--];
            }
        }
        if(lastA>=0){
            while(lastA>=0){
                a[idx--] = a[lastA--];
            }
        }
        if(lastB>=0){
            while(lastB>=0){
                a[idx--] = a[lastB--];
            }
        }
        return a;
    }
}
