package treeandgraph.weavelist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class WeaveList {

    public static void main(String[] args) {
        List<LinkedList<Integer>> results = new ArrayList<>();
        LinkedList<Integer> first = new LinkedList<>();
        first.add(1);
        first.add(2);
        LinkedList<Integer> second = new LinkedList<>();
        second.add(3);
        second.add(4);
        LinkedList<Integer> prefix = new LinkedList<>();
        results.add(first);
        results.add(second);
        results.add(prefix);

        results = weaveList(results, first, second, prefix);
        results.forEach(System.out::println);
    }
    @SuppressWarnings("unchecked")
    static List<LinkedList<Integer>> weaveList(List<LinkedList<Integer>> results,
                       LinkedList<Integer> first,LinkedList<Integer> second,LinkedList<Integer> prefix){

        if(first.size()==0 || second.size()==0){
            LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();

            result.addAll(first);
            result.addAll(second);
            results.add(result);
            return results;
        }
        Integer prefixFirst = first.removeFirst();
        prefix.add(prefixFirst);
        weaveList(results, first, second, prefix);
        prefix.removeLast();
        first.add(prefixFirst);

        Integer prefixSecond = second.removeFirst();
        prefix.add(prefixSecond);
        weaveList(results, first, second, prefix);
        prefix.removeLast();
        second.add(prefixSecond);

        return results;
    }
}
