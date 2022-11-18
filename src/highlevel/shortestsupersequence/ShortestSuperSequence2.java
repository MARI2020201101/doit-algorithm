package highlevel.shortestsupersequence;

import java.util.*;

class ShortestSuperSequence2 {
    static int[] small = {1,5,9};
    static int[] big = {7,5,9,0,2,1,3,5,7,9,1,1,5,8,8,9,7};

    public static void main(String[] args) {
        int[][] indexes = createIndexList(small, big);
        int[] closure = findClosure(indexes);
        print(indexes);
        System.out.println(Arrays.toString(closure));
        int min = Arrays.stream(closure).min().getAsInt();

    }

    static int[] findClosure(int[][] indexes){
        int[] closure = new int[indexes[0].length];
        for (int i = 0; i < indexes[0].length; i++) {
            int max = -1;
            int min = Integer.MAX_VALUE;
            int j;
            int len = -1;
            for (j = 0; j < indexes.length; j++) {
                if(indexes[j][i] == -1) break;
                max = Math.max(max, indexes[j][i]);
                min = Math.min(min, indexes[j][i]);
            }
            if(j==indexes.length) {
                len = max-i;
            }
            closure[i]=len;
        }
        return closure;
    }
    static int[][] createIndexList(int[] small, int[] big){
        int[][] indexes = new int[small.length][big.length];
        for (int i = 0; i < small.length; i++) {
            indexes[i] = indexAt(big, small[i]);
        }
        return indexes;
    }
    static int[] indexAt(int[] big, int target){
        int[] indexAt = new int[big.length];
        int next = -1;
        for (int i = big.length-1; i >= 0; i--) {
            if(big[i] == target){
                next = i;
            }
            indexAt[i] = next;
        }
        return indexAt;
    }
    static void print(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] +" ");
            }
            System.out.println();
        }
    }
}
