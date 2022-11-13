package highlevel.circustower;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CircusTower {
    static List<WtHt> arr = new ArrayList<>();

    public static void main(String[] args) {
        init();
        List<WtHt> longestSeq = longestSeq(arr);
        longestSeq.forEach(System.out::println);
    }
    static List<WtHt> longestSeq(List<WtHt> arr){
        Collections.sort(arr);
       List<List<WtHt>> solutions = new ArrayList<>();
        List<WtHt> bestSeq = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            List<WtHt> solution = longestSeqAtIndex(i, solutions, arr);
            solutions.add(i, solution);
            bestSeq = max(bestSeq, solution);
        }
        return bestSeq;
    }

    private static List<WtHt> longestSeqAtIndex(int i, List<List<WtHt>> solutions, List<WtHt> arr) {
        WtHt value = arr.get(i);
        List<WtHt> bestSeq = new ArrayList<>();
        for (int j = 0; j < i; j++) {
            List<WtHt> solution = solutions.get(j);
            WtHt lastVal = solution.get(solution.size() - 1);
            if(canAppend(value, lastVal)){
                bestSeq = max(bestSeq, solution);
            }
        }
        bestSeq.add(value);
        return bestSeq;
    }

    private static List<WtHt> max(List<WtHt> bestSeq, List<WtHt> solution) {
        return bestSeq.size() > solution.size() ? bestSeq : solution;
    }

    private static boolean canAppend(WtHt value, WtHt lastVal) {
        return value.compareTo(lastVal) < 0;
    }

    static void init(){
        arr.add(new WtHt(65,100));
        arr.add(new WtHt(70,150));
        arr.add(new WtHt(56,90));
        arr.add(new WtHt(75,190));
        arr.add(new WtHt(60,95));
        arr.add(new WtHt(68,110));
    }
}
class WtHt implements Comparable<WtHt>{
    int wt;
    int ht;
    public WtHt(int wt, int ht) {
        this.wt = wt;
        this.ht = ht;
    }

    @Override
    public String toString() {
        return "WtHt{" +
                "wt=" + wt +
                ", ht=" + ht +
                '}';
    }

    @Override
    public int compareTo(WtHt o) {
        if(this.ht!=o.ht){
            return ht - o.ht;
        }else{
            return wt - o.wt;
        }
    }
}