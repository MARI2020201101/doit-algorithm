package treeandgraph.countpathfromsumnode;

class Node {
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