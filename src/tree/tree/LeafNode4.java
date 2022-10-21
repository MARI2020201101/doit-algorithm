package tree.tree;

import java.util.ArrayList;
import java.util.List;

class LeafNode4 {
    static int N = 9;
    static int NO_PARENT = -2;
    static Node[] nodes = new Node[N];
    static int target = 4;
    static {
        for (int i = 0; i < N; i++) {
            nodes[i] = new Node(i,new ArrayList<>());
        }
        nodes[0].children.add(1);
        nodes[0].children.add(2);
        nodes[2].children.add(3);
        nodes[2].children.add(4);
        nodes[4].children.add(5);
        nodes[4].children.add(6);
        nodes[6].children.add(7);
        nodes[6].children.add(8);
    }
    static int leafNodeCount = 0;

    public static void main(String[] args) {
        deleteNode(4);
        System.out.println("leafnode count = "+countLeafNode());
    }

    static void deleteNode(int target){
        for (Integer child : nodes[target].children) {
            deleteNode(child);
            nodes[target].children = new ArrayList<>();
        }
    }
    static int countLeafNode(){
        for (int i = 0; i < nodes.length ; i++){
            if(nodes[i].children.size() == 0) leafNodeCount++;
        }
        return leafNodeCount;
    }
}
class Node{
    int parent;
    List<Integer> children = new ArrayList<>();

    public Node(int parent, List<Integer> children) {
        this.parent = parent;
        this.children = children;
    }
}