package tree.binary.node;

class Traversal {
    public static void main(String[] args) {
        Node root = new Node('A');
    }
}
class Node{
    char value = '.';
    Node left = null;
    Node right = null;

    void addChild(String value, Node left, Node right){
        char root = value.charAt(0);
        char lVal = value.charAt(1);
        char rVal = value.charAt(2);
        if(this.value == root){
            if(lVal != '.') this.left = new Node(lVal);
            if(rVal != '.') this.right = new Node(rVal);
        }
        else{
            addChild(value, left.left, right.right);
        }
    }


    @Override
    public String toString() {
        return "Node{" +
                "val=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    Node(char value){
        this.value = value;
    }
}