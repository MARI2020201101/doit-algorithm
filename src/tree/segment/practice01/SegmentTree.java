package tree.segment.practice01;

import java.util.Arrays;

class SegmentTree {
    static int[] arr = {1,2,3,4,5,6,7,8};
    static int N = arr.length;

    static int[] subsum = new int[(int) Math.pow(2,(Math.floor(Math.log(N)/Math.log(2)))+1)];
    static int M = subsum.length;

    public static void main(String[] args) {
        segmentTree();
        update(3,6);
        System.out.println(Arrays.toString(subsum));
    }

    static void update(int idx, int val){
        arr[idx] = val;
        int diff = val - subsum[idx];
        subsum[idx] += diff;
        idx= idx + M/2;
        while(idx<M){
            subsum[idx] += diff;

        }
    }


    static void segmentTree(){
        for (int i = 0; i < N ; i++) {
            subsum[i] = arr[i];
        }
        System.out.println(Arrays.toString(subsum));
        for (int i = 0; i < N; i++) {
            subsum[M/2+i] = subsum[i] + subsum[i+1];
        }
        System.out.println(Arrays.toString(subsum));
    }
}
