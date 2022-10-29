package treeandgraph.successor.practice02;

class Successor {
    public static void main(String[] args) {
        Node root = new Node(10);

        Node node1 = new Node(5);
        node1.addRight(4);
        node1.addRight(3);
        root.addLeftNode(node1);
        root.addLeft(9);
        root.addLeft(8);
        root.addLeft(7);

        root.addRight(11);
        Node node2 = new Node(12);
        Node node3 = new Node(13);
        node2.addLeftNode(node3);
        node2.addLeft(14);
        root.addRightNode(node2);
        root.addRightNode(new Node(15));
        Node node4 = new Node(16);
        root.addRightNode(node4);



        System.out.println(root);
        System.out.println(inorderSuccessor(node1));
        System.out.println(inorderSuccessor(node2));
        System.out.println(inorderSuccessor(node4));


    }
    static Node inorderSuccessor(Node n){
        if(n.right!=null){
            return mostLeftRightNode(n.right);
        }
        Node p = n.parent;
        while(p!=null && p.left != n){
            n = p;
            p = p.parent;
        }
        return p;
    }

    private static Node mostLeftRightNode(Node right) {
        Node parent = right;
        Node mostLeft = right.left;
        while(mostLeft!=null){
            parent = mostLeft;
            mostLeft = mostLeft.left;
        }
        return parent;
    }
}
class Node{
    int data;
    Node parent;
    Node left;
    Node right;

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", left=" + (left==null? "N" : left) +
                ", right=" +(right==null? "N" : right) +
                "}\n";
    }

    Node(int data){
        this.data = data;
    }
    void addLeft(int data){
        addLeft(this, data);
    }
    void addLeftNode(Node leftNode){
        addLeftNode(this, leftNode);
    }
    void addRightNode(Node rightNode){
        addRightNode(this, rightNode);
    }

    private void addRightNode(Node node, Node rightNode) {
        if(node.right == null){
            node.right = rightNode;
            rightNode.parent = node;
            return;
        }
        addLeftNode(node.right, rightNode);
    }

    private void addLeftNode(Node node, Node leftNode) {
        if(node.left == null){
            node.left = leftNode;
            leftNode.parent = node;
            return;
        }
        addLeftNode(node.left, leftNode);
    }

    void addRight(int data){
        addRight(this, data);
    }
    private void addLeft(Node node, int data){
        if(node.left == null){
            Node child = new Node(data);
            node.left = child;
            child.parent = node;
            return;
        }
        addLeft(node.left, data);
    }
    private void addRight(Node node, int data){
        if(node.right == null){
            Node child = new Node(data);
            node.right = child;
            child.parent = node;
            return;
        }
        addRight(node.right, data);
    }
}