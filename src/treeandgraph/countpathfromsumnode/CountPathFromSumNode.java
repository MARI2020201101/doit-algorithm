package treeandgraph.countpathfromsumnode;
import java.util.HashMap;

class CountPathFromSumNode {
    public static void main(String[] args) {
        Node root = new Node(10);
        Node node1 = new Node(5);
        Node node2 = new Node(3);
        Node node3 = new Node(3);
        Node node4 = new Node(-2);
        node2.addLeftNode(node3);
        node2.addRightNode(node4);
        Node node5 = new Node(1);
        Node node6 = new Node(2);
        node1.addLeftNode(node2);
        node1.addRightNode(node5);
        node1.addRightNode(node6);
        Node node7 = new Node(-3);
        Node node8 = new Node(11);
        node7.addRightNode(node8);
        root.addLeftNode(node1);
        root.addRightNode(node7);

        System.out.println(countPathsWithSum(root, 8));

    }

    static int countPathsWithSum(Node root, int targetSum){
        return countPathsWithSum(root, targetSum, 0 ,new HashMap<Integer, Integer>());
    }

    private static int countPathsWithSum(Node node, int targetSum, int runningSum, HashMap<Integer, Integer> sumMap) {
        if(node == null) return 0;

        runningSum += node.data;
        int totalCount = sumMap.getOrDefault(runningSum - targetSum, 0);

        if(runningSum == targetSum){
            totalCount++;
        }
        incrementPathCount(sumMap, runningSum, 1);
        totalCount+=countPathsWithSum(node.left, targetSum, runningSum, sumMap);
        totalCount+=countPathsWithSum(node.right, targetSum, runningSum, sumMap);
        incrementPathCount(sumMap, runningSum, -1);

        return totalCount;
    }

    private static void incrementPathCount(HashMap<Integer, Integer> sumMap, int key, int delta) {
        Integer pathCount = sumMap.getOrDefault(key, 0) + delta;
        if(pathCount == 0){
            sumMap.remove(key);
        }else{
            sumMap.put(key, pathCount);
        }
    }
}

