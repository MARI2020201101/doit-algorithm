package dynamicprogramming.logestsubsequence;

import java.util.ArrayList;
import java.util.List;

class LongestSubSequence {
//    static int[] arr ={10,20,10,30,20,50};
    static int[] arr ={11,5,10,12,7,14,3,8,24,2};
    static int N = arr.length;

    public static void main(String[] args) {
        List<Integer> solution = new ArrayList<>();
        List<Integer> bestSolution = recur(0, solution);
        bestSolution.forEach(System.out::println);
    }

    static List<Integer> recur(int index, List<Integer> solution){
        if(index >= N){
            return solution;
        }
        int item = arr[index];
        List<Integer> addedSolution = new ArrayList<>();
        if(canAppend(item, solution)){
            ArrayList<Integer> nextSolution = new ArrayList<>(solution);
            nextSolution.add(item);
            addedSolution = recur(index + 1, nextSolution);
        }
        List<Integer> nonAddedSolution = recur(index + 1, solution);

        return addedSolution.size() > nonAddedSolution.size() ? addedSolution : nonAddedSolution;
    }

    private static boolean canAppend(int item, List<Integer> solution) {
        if(solution.isEmpty()) return true;
        Integer last = solution.get(solution.size() - 1);
        if(last<item) return true;
        return false;
    }
}
