package dynamicprogramming.logestsubsequence;

import java.util.ArrayList;
import java.util.List;

public class LongestSubSequence2 {
    static int[] arr ={10,20,10,30,20,50};
    static int N = arr.length;

    public static void main(String[] args) {
        List<Integer> bestSolution = findBestSolution(arr);
        bestSolution.forEach(System.out::println);

        System.out.println("=======");
        int[] arr2 ={11,5,10,12,7,14,3,8,24,2};
        List<Integer> bestSolution2 = findBestSolution(arr2);
        bestSolution2.forEach(System.out::println);
    }

    static List<Integer> findBestSolution(int[] arr){
        List<List<Integer>> solutions = new ArrayList<>();
        List<Integer> bestSolution = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            List<Integer> solution = findSolutionAtIndex(i, arr, solutions);
            solutions.add(i, solution);
            bestSolution = solution.size() > bestSolution.size() ? solution : bestSolution;
        }
        return bestSolution;
    }

    private static List<Integer> findSolutionAtIndex(int index, int[] arr, List<List<Integer>> solutions) {
        int item = arr[index];
        List<Integer> longestSolution = new ArrayList<>();
        if(index == 0){
            longestSolution.add(item);
            return longestSolution;
        }
        for(int i = 0 ; i < index ; i++){
            List<Integer> solution = solutions.get(i);
            if(canAppend(item, solution) && isLongestSolution(longestSolution, solution)){
                List<Integer> nextSolution = new ArrayList<>(solution);
                nextSolution.add(item);
                longestSolution = nextSolution;
            }
        }
        return longestSolution;
    }
    private static boolean isLongestSolution(List<Integer> prev , List<Integer> cand){
        return prev.size() <= cand.size();
    }
    private static boolean canAppend(int item, List<Integer> solution) {
        if(solution.isEmpty()) return true;
        Integer last = solution.get(solution.size() - 1);
        if(last < item) return true;
        return false;
    }
}
