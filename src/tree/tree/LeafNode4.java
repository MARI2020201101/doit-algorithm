package tree.tree;

import java.util.ArrayList;
import java.util.List;

class LeafNode4 {
    static int N = 9;
    static Node[] nodes = new Node[N];
    static int target = 4;
    static {
        nodes[0].children.add(1);
        nodes[0].children.add(2);
        nodes[2].children.add(3);
        nodes[2].children.add(4);
        nodes[4].children.add(5);
        nodes[4].children.add(6);
        nodes[6].children.add(7);
        nodes[6].children.add(8);
    }

    static void deleteNode(int target){
        for (Integer child : nodes[target].children) {
            deleteNode(child);

        }
    }
}
class Node{

    List<Integer> children = new ArrayList<>();

    public Node( List<Integer> children) {

        this.children = children;
    }
}