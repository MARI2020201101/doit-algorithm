package highlevel.shortestsupersequence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ShortestSuperSequence {
    static int[] small = {1,5,9};
    static int[] big = {7,5,9,0,2,1,3,5,7,9,1,1,5,8,8,9,7};

    public static void main(String[] args) {
        List<List<Integer>> indexList = createIndexList(small, big);
        getShortestSuperSequence(indexList);
    }
    static List<List<Integer>> createIndexList(int[] small, int[] big){
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < small.length; i++) {
            map.put(small[i], new ArrayList<>());
        }

        for (int i = 0; i < big.length; i++) {
            if(map.get(big[i])!= null){
                List<Integer> list = map.get(big[i]);
                list.add(i);
            }
        }
        List<List<Integer>> queue = new ArrayList<>();
        queue.addAll(map.values());
        return queue;
    }
    static int getShortestSuperSequence(List<List<Integer>> queue){
        int smalls = queue.size();
        for (int i = 0; i < queue.size(); i++) {
            int max = -1;
            int min = Integer.MAX_VALUE;
            int distance = Integer.MAX_VALUE;
            for (int j = 0; j < queue.get(i).size(); j++) {
                Integer val = queue.get(i).get(j);
                max = Math.max(val, max);
                min = Math.min(val, min);

            }
            distance = Math.min(distance,max-min);
            System.out.println("d = "+distance);

        }
        return 0;
    }
}
