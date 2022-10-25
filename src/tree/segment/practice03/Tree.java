package tree.segment.practice03;

import java.util.Arrays;

class Tree {
    static int[] arr = {1,2,3,4,5,6,7,8,9,10};
    static int[] tree = new int[calculateTreeSize(arr.length)];

    public static void main(String[] args) {

        sumSegmentTree(tree, 1, 0, arr.length -1);
        System.out.println(Arrays.toString(tree));
        System.out.println(subsum(1,1,arr.length-1,2,7));
    }

    static int calculateTreeSize(int arrSize){
        double maxArrSize = Math.ceil(Math.log(arrSize) / Math.log(2));
        return (int) Math.pow(2, maxArrSize + 1);
    }

    static int minSegmentTree(int[] tree, int node, int start, int end){
        if(start == end) return tree[node] = arr[start];

        tree[node] = Math.min(
                minSegmentTree(tree, node * 2, start, (start + end)/2)
                , minSegmentTree(tree, node * 2 + 1,(start+end)/2+1,end));
        return tree[node];
    }
    static int sumSegmentTree(int[] tree, int node, int start, int end){
        if(start == end){
            return tree[node] = arr[start];
        }
         tree[node] =
                sumSegmentTree(tree,node*2, start,(start+ end)/2)
                + sumSegmentTree(tree,node*2+1,(start+end)/2+1, end);
        return tree[node];
    }
    static int subsum(int node, int start, int end, int sumStart, int sumEnd) {
        if(start > sumEnd || end < sumStart){
            return 0;
        }
        if(sumStart <= start && end <= sumEnd){
            return tree[node];
        }
        else   return subsum(node*2, start, (start+end)/2 , sumStart, sumEnd)
           + subsum(node*2+1, (start+end)/2+1, end, sumStart, sumEnd);
    }

}
