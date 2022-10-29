package treeandgraph.successor.practice01;


class Successor {
    public static void main(String[] args) {
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

        System.out.println(inorderSuccessor(node4));
        System.out.println(inorderSuccessor(node5));
    }

    static Node inorderSuccessor(Node node){
        if(node.right!=null) return node.right;
        Node p = node.parent;
        if(p.left == node) return p.right;
        else{
            Node curr = node;
            while(p != null && p.right == curr){
                curr = p;
                p = p.parent;
            }
            return p;
        }
    }
}
class Node {
    int data;
    Node left;
    Node right;
    Node parent;

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
        if(this.left == null) {
            Node node = new Node(data);
            this.left = node;
            node.parent = this;
        }
        else{
            Node node = left;
            while(node.left!=null){
                node = node.left;
            }
            Node child = new Node(data);
            node.left = child;
            child.parent = this;
        }
    }

    public void addLeft(Node data){
        if(this.left == null) {
            this.left = data;
            data.parent = this;
        }
        else{
            Node node = left;
            while(node.left!=null){
                node = node.left;
            }
            node.left = data;
            data.parent = this;
        }
    }

    public void addRight(int data){
        if(this.right == null)  {
            Node node = new Node(data);
            this.right = node;
            node.parent = this;

        }
        else{
            Node node = right;
            while(node.right!=null){
                node = node.right;
            }
            Node child = new Node(data);
            node.right = child;
            child.parent = this;
        }
    }

    public void addRight(Node data){
        if(this.right == null) {
            this.right = data;
            data.parent = this;
        }
        else{
            Node node = right;
            while(node.right!=null){
                node = node.right;
            }
            node.right = data;
            data.parent = this;
        }
    }
}