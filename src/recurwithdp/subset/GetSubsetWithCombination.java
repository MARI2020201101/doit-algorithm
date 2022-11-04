package recurwithdp.subset;

import java.util.ArrayList;
import java.util.List;

class GetSubsetWithCombination {
    public static void main(String[] args) {
        List<Integer> set = new ArrayList<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        List<List<Integer>> subset = getSubset(set);
        subset.forEach(System.out::println);
    }
    static List<List<Integer>> getSubset(List<Integer> set){
        int n = 1 << set.size();
        List<List<Integer>> resultSet = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            List<Integer> subset = getSubset(set , i);
            resultSet.add(subset);
        }
        return resultSet;
    }

    private static List<Integer> getSubset(List<Integer> set, int n) {
        List<Integer> subset = new ArrayList<>();
        int x = n;
        int index = 0;
        while(x>0 && index < set.size()){
            if((x & 1) == 1){
                subset.add(set.get(index));
            }
            index++;
            x>>=1;
        }

        return subset;
    }
}
