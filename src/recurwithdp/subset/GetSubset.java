package recurwithdp.subset;

import java.util.ArrayList;

class GetSubset {
    public static void main(String[] args) {
        ArrayList<Integer> set = new ArrayList<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        ArrayList<ArrayList<Integer>> subset = getSubset(set, 0);
        subset.forEach(System.out::println);
    }
    static ArrayList<ArrayList<Integer>> getSubset(ArrayList<Integer> set, int index){
        if(index == set.size()){
            ArrayList<ArrayList<Integer>> resultSet = new ArrayList<>();
            resultSet.add(new ArrayList<>());
            return resultSet;
        }
        ArrayList<ArrayList<Integer>> list = getSubset(set, index + 1);
        ArrayList<ArrayList<Integer>> resultSet = new ArrayList<>();
        Integer item = set.get(index);
        for (int i = 0; i < list.size(); i++) {
            ArrayList<Integer> nextList = new ArrayList<>();
            nextList.addAll(list.get(i));
            nextList.add(item);
            resultSet.add(nextList);
        }
        resultSet.addAll(list);
        return resultSet;
    }
}
