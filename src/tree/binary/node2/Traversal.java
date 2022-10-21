package tree.binary.node2;

class Traversal {
    public static void main(String[] args) {
        Tree tree = new Tree(new Node('A'));
        tree.addNode('A','B','C');
        tree.addNode('B','D','.');
        tree.addNode('C','E','F');
        tree.addNode('E','.','.');
        tree.addNode('F','.','G');
        tree.addNode('D','.','.');
        tree.addNode('G','.','.');

        tree.preOrder();
    }
}
class Tree{
    Node root;
    Tree(Node node){
        root = node;
    }
    void addNode(char rootVal, char leftVal, char rightVal){
        if(root.val == rootVal){
            if(leftVal!='.') root.left = new Node(leftVal);
            if(rightVal!='.') root.right = new Node(rightVal);
        }else{
            searchNode(root, rootVal, leftVal, rightVal);
        }
    }

    void searchNode(Node node, char rootVal, char leftVal, char rightVal){
        if(node == null) return;
        if(node.val == rootVal) {
            if(leftVal!='.') node.left = new Node(leftVal);
            if(rightVal!='.') node.right = new Node(rightVal);
        }
        else{
            searchNode(node.left, rootVal, leftVal, rightVal);
            searchNode(node.right, rootVal, leftVal, rightVal);
        }
    }
    void preOrder(){
        preOrder(root);
    }
    private void preOrder(Node node){
        if(node == null) return;
        System.out.print(node.val);
        preOrder(node.left);
        preOrder(node.right);
    }
}
class Node{
    char val;
    Node left;
    Node right;

    public Node(char val) {
        this.val = val;
    }

    public Node(char val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
