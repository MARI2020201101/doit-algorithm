package tree.segment.submul;

import java.util.Arrays;

class SegmentTree {
    static int[] arr = {1,2,3,4,5};
    static int[] tree = new int[lenOfTree(arr)];

    public static void main(String[] args) {
        System.out.println(lenOfTree(arr));
        createMultiplySegmentTree(tree);
        System.out.println(Arrays.toString(tree));
    }
    static int lenOfTree(int[] arr){
        int arrLen = arr.length;
        return (int) (Math.pow(2, Math.ceil(Math.log(arrLen)/Math.log(2))+1));
    }
    static void createMultiplySegmentTree(int[] tree){
        Arrays.setAll(tree, a -> 1);
        createMultiplySegmentTree(tree, 1, 0, arr.length-1);
    }
    private static int createMultiplySegmentTree(int[] tree, int node, int start, int end){
        if(start == end){
            return tree[node] = arr[start];
        }
        else {
            return tree[node] =
                    createMultiplySegmentTree(tree, node*2 , start, (start+end)/2)
                     * createMultiplySegmentTree(tree, node*2+1 , (start+end)/2+1, end);
        }
    }
}
