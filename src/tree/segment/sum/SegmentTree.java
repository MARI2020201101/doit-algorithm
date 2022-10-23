package tree.segment.sum;

import java.util.Arrays;

class SegmentTree {
    static int[] arr = {1,2,3,4,5};
    static int N = arr.length;

    static int[] subsum = new int[(int) Math.pow(2,(Math.floor(Math.log(N)/Math.log(2))+1)+1)];
    static int M = subsum.length;

    public static void main(String[] args) {
        segmentTree();
        update(3,6);
        System.out.println(Arrays.toString(subsum));


    }


    static int sum(int start, int end){
        int result = 0;
        while(start +1< end ){
            System.out.println(String.format("start=%d, end=%d", start,end));
            if(start % 2 == 0 ){
                result += subsum[start];
            }
            if(end % 2 == 1){
                result += subsum[end];

            }
            start/=2;
            end/=2;
        }
        return result;
    }
    static void update(int idx, int val){
        arr[idx] = val;
        int sIdx = M / 2 + idx;
        int original = subsum[sIdx];
        int diff = val-original;
        subsum[sIdx] = val;
        while(sIdx/2 > 0){
            sIdx=sIdx/2;
            subsum[sIdx] += diff;
        }
    }


    static void segmentTree(){
        for (int i = 0,j = M/2; i < N ; i++,j++) {
            subsum[j] = arr[i];
        }
        for (int i = M/2-1; i >= 0 ; i--) {
            subsum[i] = subsum[i*2] + subsum[i*2+1];
        }
    }
}
