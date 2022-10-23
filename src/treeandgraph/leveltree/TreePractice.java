package treeandgraph.leveltree;

import java.util.ArrayList;
import java.util.LinkedList;

class TreePractice {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.recurNode(3);
        tree.recurNode(1);
        tree.recurNode(2);
        tree.recurNode(4);
        tree.recurNode(5);
        tree.printNode();
        System.out.println();
        ArrayList<LinkedList<Node>> lists = new ArrayList<>();
        lists = tree.createLevelTree(lists, 0);
        lists.stream().forEach(System.out::println);
    }
}

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }

    public Node() {
    }

    @Override
    public String toString() {
        return "Node[" + data + "]";
    }
}

class Tree{
    Node root = null;
    void recurNode(int data){
        if(root == null){
            root = new Node(data);
            return;
        }
        Node node = root;
        recurNode(node, data);
    }

    private Node recurNode(Node node, int data){
        if(node == null){
            return new Node(data);
        }
        if (node.data >= data) {
            node.left = recurNode(node.left, data);
        } else{
            node.right = recurNode(node.right, data);
        }
        return node;
    }

    void printNode(){
        printNode(root);
    }

    private void printNode(Node node){
        if(node == null) return;
        printNode(node.left);
        System.out.print(node.data);
        System.out.print("->");
        printNode(node.right);
    }
    int depthOfTree(){
        return depthOfTree(root);
    }
    private int depthOfTree(Node node){
        if(node == null) return 0;
        return Math.max(depthOfTree(node.left), depthOfTree(node.right)) + 1;
    }
    ArrayList<LinkedList<Node>> createLevelTree(ArrayList<LinkedList<Node>> lists, int level){
        return createLevelTree(root, lists, level);
    }
    private ArrayList<LinkedList<Node>> createLevelTree(Node node, ArrayList<LinkedList<Node>> lists, int level){
        if(node == null){
            LinkedList<Node> list = new LinkedList<>();
            lists.add(list);
            return lists;
        }
        createLevelTree(node.left, lists, level + 1);
        createLevelTree(node.right, lists, level + 1);

        LinkedList<Node> list = lists.get(level);
        list.add(node);
        lists.add(list);
        return lists;
    }
}