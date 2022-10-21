package tree.binary;

import java.util.ArrayList;
import java.util.List;

class Another {
    static List<Node> nodes = new ArrayList<>();
    static {
        Node root = new Node("ABC");
        root.addNode("BD.");
//        nodes.add();
        nodes.add(new Node("BD."));
        nodes.add(new Node("CEF"));
        nodes.add(new Node("E.."));
        nodes.add(new Node("F.G"));
        nodes.add(new Node("D.."));
        nodes.add(new Node("G.."));
    }

    public static void main(String[] args) {
        inOrder(nodes.get(0));
    }
    static void inOrder(Node node){
        if(node == null){
            return;
        }
        System.out.print(node.curr);
        inOrder(node.left);
        inOrder(node.right);
    }
}
class Node{
    char curr;
    Node left;
    Node right;


    public Node(String abc) {
        this.addNode(abc);
    }

    void addNode(String str){
        this.curr = str.charAt(0);
        if(str.charAt(1)!='.'){
            Node start = left;
            while(start != null){
                start = start.left;
            }
            start = new Node(str.charAt(1));
        }else{
            this.left = null;
        }

        Node start = right;
        while(start != null){
            start = start.right;
        }
        if(str.charAt(2)!='.'){
            this.right = new Node(str.charAt(2));
        }else{
            this.right = null;
        }
    }

    public Node(char curr) {
        this.curr = curr;
    }

    public Node(char curr, Node left, Node right) {
        this.curr = curr;
        this.left = left;
        this.right = right;
    }
}
