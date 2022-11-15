package dynamicprogramming.logestsubsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestSubSequence3 {
    static int[] arr ={11,5,10,12,7,14,3,8,24,2};
    static int N = arr.length;
    static List<Integer> solutionCand = new ArrayList<>();
    static List<Integer> solution = new ArrayList<>();
    static int[] indexAtSolutionCand = new int[N];
    // dp 로 푸는 방법 vs 이분탐색으로 푸는 방법
    // arr 의 길이만큼 solutionCand를 업데이트.
    // solutionCand의 size가 곧 maxLength가 된다.

    public static void main(String[] args) {
        solve();
        solutionCand.forEach(e-> System.out.print(e + " "));
        System.out.println();
        System.out.println(Arrays.toString(indexAtSolutionCand));
        solution.forEach(e-> System.out.print(e + " "));
    }
    static void solve(){
        for (int i = 0; i < arr.length; i++) {
            int item = arr[i];
            if(canAppend(item, solutionCand)){
                solutionCand.add(item);
                indexAtSolutionCand[i]=solutionCand.size();
            }else{
                int left = 0;
                int right = solutionCand.size() - 1 ;
                int index = binarySearch(left, right, solutionCand, item);
                indexAtSolutionCand[i]=index+1;
            }
        }
        int count = solutionCand.size();
        while(count > 0){
            for (int i = indexAtSolutionCand.length-1; i >= 0 ; i--) {
                if(count == indexAtSolutionCand[i]){
                    solution.add(arr[i]);
                    --count;
                }
            }
        }
        Collections.reverse(solution);
    }

    private static int binarySearch(int left, int right, List<Integer> solutionCand, int item) {
        while(left < right){
            int mid = (left + right)/2;
            if(solutionCand.get(mid) > item){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        solutionCand.set(left, item);
        return left;
    }

    private static boolean canAppend(int item, List<Integer> solutionCand) {
        if(solutionCand.isEmpty()) return true;
        Integer last = solutionCand.get(solutionCand.size() - 1);
        if(last < item) return true;
        return false;
    }

}
