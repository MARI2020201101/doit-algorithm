package treeandgraph.successor.practice01;

class Successor2 {


    static void inorderSuccessor(Node n){


    }
    static private void sampleNodes(){
        Node root = new Node(20);
        Node node1 = new Node(10);
        Node node2 = new Node(5);
        node2.addLeft(3);
        Node node5 = new Node(7);
        node2.addRight(node5);
        Node node3 = new Node(15);
        Node node4 = new Node(17);
        node3.addRight(node4);
        node1.addRight(node3);
        root.addRight(30);
    }
}
