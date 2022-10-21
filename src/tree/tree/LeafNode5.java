package tree.tree;

import java.util.ArrayList;
import java.util.List;

class LeafNode5 {
    static int N = 9;
    static boolean[] visited = new boolean[N];
    static MyNode[] nodes = new MyNode[N];
    static int target = 4;
    static int leafNodeCount = 0;
    static {
        for (int i = 0; i < N; i++) {
            nodes[i] = new MyNode(i);
        }
        nodes[0].addChild(new MyNode(1), new MyNode(2));
        nodes[2].addChild(new MyNode(3), new MyNode(4));
        nodes[4].addChild(new MyNode(5), new MyNode(6));
        nodes[6].addChild(new MyNode(7), new MyNode(8));
    }

    public static void main(String[] args) {
        deleteChildNode(target);
        countLeafNode(0);
        System.out.println(leafNodeCount);
    }


    static void deleteChildNode(int target){
        for(MyNode child : nodes[target].children){
            nodes[target].children.remove(child);
            deleteChildNode(child.idx);
        }

    }

    static void countLeafNode(int parent){
        visited[parent] = true;
        if(nodes[parent].children.size() == 0 ) {
            leafNodeCount++;
            return;
        }
        else {
            for(MyNode child : nodes[parent].children){
                if(! visited[child.idx]){
                    countLeafNode(child.idx);
                }
            }
        }

    }
}

class MyNode{
    int idx;
    List<MyNode> children = new ArrayList<>();

    public MyNode(int idx) {
        this.idx = idx;
    }
    public void addChild(MyNode... child){
        for(MyNode c : child){
            this.children.add(c);
        }
    }
}