package treeandgraph.containstree.matchtree;

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