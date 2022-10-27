package tree.segment.submul;

import java.util.Arrays;

class SegmentTreeV2 {
    static int[] arr = {1,2,3,4,5};
    static int[] tree = new int[lenOfTree(arr)];

    public static void main(String[] args) {
        createTree(arr, tree);
        System.out.println(Arrays.toString(tree));
        System.out.println(calculate(tree, 1,4));
    }

    static void createTree(int[] arr, int[] tree){
        int treeLen = tree.length;
        for (int i = treeLen/2 ; i < treeLen; i++) {
            tree[i] = 1;
        }
        for (int i = 0; i < arr.length; i++) {
            tree[treeLen/2 + i] = arr[i];
        }
        for (int i = treeLen-1; i > 0 ; i-=2) {
            tree[i/2] = tree[i] * tree[i-1];
        }
    }
    static int calculate(int[] tree, int startSub, int endSub){
        int result = 1;
        int length = tree.length / 2;
        startSub += length;
        endSub += length;
        //인덱스 1,2,3,4
        //값 2,3,4,5
        while(startSub<endSub){
            System.out.println(String.format("startSub=%d, endSub=%d, result=%d",startSub,endSub,result));
            if(startSub%2==0){
                result*=tree[startSub];
                startSub++;
            }
            if(endSub%2==1){
                result*=tree[endSub];
                endSub--;
            }
            startSub/=2;
            endSub/=2;
        }
        return result;
    }
    static int lenOfTree(int[] arr){
        int len = arr.length;
        int lenOfTree = 0;
        while(len!=0){
            len/=2;
            lenOfTree++;
        }
        System.out.println("lenof Tree "+ lenOfTree);
        return (int) Math.pow(2, lenOfTree+1);
    }
}
