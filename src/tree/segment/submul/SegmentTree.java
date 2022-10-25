package tree.segment.submul;

class SegmentTree {
    static int[] arr = {1,2,3,4,5};
    static int[] tree = new int[lenOfTree(arr)];

    public static void main(String[] args) {
        System.out.println(lenOfTree(arr));
    }
    static int lenOfTree(int[] arr){
        int arrLen = arr.length;
        return (int) (Math.pow(2, Math.ceil(Math.log(arrLen)/Math.log(2))+1));
    }
    static void createMultiplySegmentTree(int[] tree){

    }
    static private void createMultiplySegmentTree(int[] tree, int node, int start, int end){
        if(start == end){

        }
    }
}
