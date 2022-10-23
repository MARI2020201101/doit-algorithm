package treeandgraph.sorted.array;

import java.util.ArrayList;
import java.util.List;

class Sorted {
    public static void main(String[] args) {
        Node root = sampleRootNode();

        Tree.inOrder(root, 0);
        ArrayList<Integer> list = new ArrayList<>();
        Tree.copyToArr(root, list);
        list.forEach(n -> System.out.print(n + ","));

        System.out.println();
        Node root2 = sampleSortedRootNode();
        System.out.println(Tree.isSortedNodes(root2));
        System.out.println(Tree.isSortedNodes(root));
    }
    private static Node sampleSortedRootNode() {
        Node root = new Node(10);
        root.addLeft(4);
        root.addLeft(3);
        root.addRight(20);
        Node node1 = new Node(2);
        node1.addLeft(1);
        node1.addRight(6);
        node1.addRight(7);
        root.addLeft(node1);
        return root;
    }
    private static Node sampleRootNode() {
        Node root = new Node(10);
        root.addLeft(4);
        root.addLeft(3);
        root.addRight(20);
        Node node1 = new Node(5);
        node1.addLeft(2);
        node1.addRight(6);
        node1.addRight(7);
        root.addLeft(node1);
        return root;
    }
}
class Result{
    Node node;
    boolean result;

    @Override
    public String toString() {
        return "Result{" +
                "node=" + node +
                ", result=" + result +
                '}';
    }

    public Result(Node node, boolean result) {
        this.node = node;
        this.result = result;
    }

    public Result() {
    }
}
class Tree {
    static Result isSortedNodes(Node root){
        if(root==null) return new Result(root, true);

        Result result = isSortedNodes(root.left);
        if(! result.result) return result;
        if(result.node == null){
            return new Result(new Node(root.data), true);
        }
        boolean sorted = result.node.data <= root.data;
        Result nextResult = new Result(new Node(root.data), sorted);
        isSortedNodes(root.right);

        return nextResult;
    }
    static void copyToArr(Node root, List<Integer> list){
        if(root==null) return;
        copyToArr(root.left, list);
        list.add(root.data);
        copyToArr(root.right, list);
    }
    static void inOrder(Node root, int depth){
        if(root==null) return;
        inOrder(root.left, depth + 1);
        for (int i = 0; i < depth; i++) {
            System.out.print("ㅡ");
        }
        System.out.print(root.data);
        System.out.println();
        inOrder(root.right, depth+1);
    }
}
class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "[" + data +
                ", left=" + left +
                ", right=" + right +
                "]";
    }

    public void addLeft(int data){
        if(this.left == null) this.left = new Node(data);
        else{
            Node node = left;
            while(node.left!=null){
                node = node.left;
            }
            node.left = new Node(data);
        }
    }

    public void addLeft(Node data){
        if(this.left == null) this.left = data;
        else{
            Node node = left;
            while(node.left!=null){
                node = node.left;
            }
            node.left =data;
        }
    }

    public void addRight(int data){
        if(this.right == null)  this.right = new Node(data);
        else{
            Node node = right;
            while(node.right!=null){
                node = node.right;
            }
            node.right = new Node(data);
        }
    }

    public void addRight(Node data){
        if(this.right == null) this.right = data;
        else{
            Node node = right;
            while(node.right!=null){
                node = node.right;
            }
            node.right =data;
        }
    }
}