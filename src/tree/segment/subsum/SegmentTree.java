package tree.segment.subsum;

import java.util.Arrays;

class SegmentTree {
    static int[] arr = {5,8,4,3,7,2,1,6};
    static int N = arr.length;
    static int[] subsum = new int[(int) (Math.pow(2,(int)(Math.log(N)+1))*2)];
    static int M = subsum.length;

    public static void main(String[] args) {
        segmentTree();

    }

    static void update(int idx, int val){
        arr[idx] = val;
        int sIdx = M / 2 + idx;
        int original = subsum[sIdx];
        int diff = original - val;
        subsum[sIdx] = val;
        while(sIdx /2 >0){
            subsum[sIdx] += diff;
            subsum[sIdx+1] += diff;
            sIdx=sIdx/2;
        }
    }


    static void segmentTree(){
        for (int i = N-1,j = M-1; i >= 0 ; i--,j--) {
            subsum[j] = arr[i];
        }
        for (int i = M/2-1; i >= 0 ; i--) {
            subsum[i] = subsum[i*2] + subsum[i*2+1];
        }
        System.out.println(Arrays.toString(subsum));
    }
}
