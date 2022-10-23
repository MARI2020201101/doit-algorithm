package tree.segment.min;

import java.util.Arrays;

class Min {
    static int[] arr = {75,30,100,38,50,51,52,20,81,5};
    static int[] tree = new int[32];

    public static void main(String[] args) {
        init(0, arr.length-1, 1);
        System.out.println(Arrays.toString(tree));
    }

    static int init(int start, int end, int index){
        if(start == end)
            return  tree[index] = arr[start];
        else{
            int mid = (start+end)/2;
            return tree[index] = Math.min(init(start, mid,index*2), init(mid+1,end,index*2+1));
        }
    }
}
