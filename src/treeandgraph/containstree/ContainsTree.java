package treeandgraph.containstree;

class ContainsTree {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.recurNode(6);
        tree.recurNode(3);
        tree.recurNode(5);
        tree.recurNode(2);
        tree.recurNode(1);
        tree.recurNode(9);

        Tree tree2 = new Tree();
        tree2.recurNode(5);
        tree2.recurNode(7);
        tree2.recurNode(5);
        tree2.recurNode(2);
        tree2.recurNode(0);
        tree2.recurNode(9);


        containsTree(tree, tree2);
    }
    static boolean containsTree(Tree tree1, Tree tree2){
        String s1 = orderString(tree1.root, new StringBuilder());
        String s2 = orderString(tree2.root, new StringBuilder());

        System.out.println("s1 : "+s1);
        System.out.println("s2 : "+s2);
        return s1.contains(s2);
    }
    static String orderString(Node node, StringBuilder sb){
        if(node == null){
            sb.append("X");
            return sb.toString();
        }
        sb.append(node.data);
        orderString(node.left, sb);
        orderString(node.right, sb);

        return sb.toString();
    }
}
class Node{
    int data;
    Node left;
    Node right;
    public Node(int data) {
        this.data = data;
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
}