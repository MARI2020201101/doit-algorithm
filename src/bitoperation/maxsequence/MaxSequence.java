package bitoperation.maxsequence;

import java.util.ArrayList;

class MaxSequence {
    public static void main(String[] args) {
        System.out.println(longestSequence(1775));
    }
    static int longestSequence(int n){
        ArrayList<Integer> sequences = createSequenceList(n);
        sequences.forEach(s-> System.out.print(s+","));
        System.out.println();
        return findLongestSequence(sequences);
    }

    private static int findLongestSequence(ArrayList<Integer> sequences) {
        int maxSequence = 1;
        for (int i = 0; i < sequences.size(); i+=2) {
            int count = sequences.get(i);
            int thisCount = 0;
            int leftBitsCount = (i==0) ? 0 : sequences.get(i-1);
            int rightBitsCount = (i == sequences.size()-1) ? 0 : sequences.get(i+1);
            if(count == 1){
                thisCount = Math.max(leftBitsCount+1+rightBitsCount, thisCount);
            }else if(count > 1){
                thisCount = Math.max(leftBitsCount+1, rightBitsCount+1);
            }else if(count == 0){
                thisCount = Math.max(leftBitsCount, rightBitsCount);
            }
            maxSequence = Math.max(thisCount, maxSequence);
        }
        return maxSequence;
    }

    private static ArrayList<Integer> createSequenceList(int n) {
        ArrayList<Integer> sequences = new ArrayList<>();
        int searchFor = 0;
        int counter = 0;
        for (int i = 0; i < Integer.BYTES*8; i++) {
            if((n & 1) != searchFor){
                searchFor = n & 1;
                sequences.add(counter);
                counter=0;
            }
            counter++;
            n>>>=1;
        }
        return sequences;
    }
}
