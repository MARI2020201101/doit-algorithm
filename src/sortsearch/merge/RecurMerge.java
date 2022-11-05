package sortsearch.merge;

import java.util.Arrays;

class RecurMerge {
    public static void main(String[] args) {
        int[] a = {1,4,9,10,22,33,46,77,79,99,0,0,0,0,0,0,0,0,0,0};
        int[] b = {2,5,6,10,21,32,39,67,89,100};
        int[] merge = merge(a, b, 9, 9,a.length-1);
        System.out.println(Arrays.toString(merge));
    }
    static int[] merge(int[] a, int[] b, int lastA, int lastB, int idx){
        if(lastA == 0 && lastB >= 0){
            while(lastA>=0){
                a[idx--] = a[lastA--];
            }
            return a;
        }else if(lastB == 0 && lastA >= 0){
            while(lastB>=0){
                a[idx--] = a[lastB--];
            }
            return a;
        }


        a[idx--] = a[lastA] > b[lastB] ? a[lastA--] : b[lastB--];

        merge(a,b,lastA, lastB, idx);

        return a;
    }
}
