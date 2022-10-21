package coding.tree;

class Tree {
    public static void main(String[] args) {
        Node root = new Node('A');
        root.addNode('B');
        root.addNode('C');
        root.addNode('D');
        root.addNode('E');
        root.addNode('F');

        Node.printNode(root);
        System.out.println(root);
    }
}
class Node{
    char curr;
    Node left;
    Node right;

    @Override
    public String toString() {
        return "Node{" +
                "curr=" + curr +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    public static void printNode(Node node){
        if(node == null) return;
        System.out.println(node.curr);
        printNode(node.left);
        printNode(node.right);
    }

    public Node addNode(char value){
        Node node =  new Node(value);
        while(this.left != null || this.right!= null){
            left = left.left;
            right = right.right;
        }
        if(this.left == null){
            left = node;
            return left;
        }else{
            right = node;
            return right;
        }
    }
    public Node(char val){
        this.curr = val;
        this.left = null;
        this.right = null;
    }
    public Node(char curr, Node left, Node right) {
        this.curr = curr;
        this.left = left;
        this.right = right;
    }
}
