package linkedlist.practice02;

class Tree {
    Node root = new Node();
    public Tree(int data){
        root.data = data;
    }
    public void addNode(int data){
        Node node = root;
        while(node.next!=null){
            node = node.next;
        }
        node.next = new Node(data);
    }

    public void printNode(){
        Node node = root;
        System.out.print(node.data);
        while(node.next!= null){
            System.out.print(" -> ");
            System.out.print(node.next.data);
            node = node.next;
        }
        System.out.println();
    }


    public Node kthNode(Node node, int k, Index index){
        if(node == null) return null;
        Node next = kthNode(node.next, k, index);
        index.value += 1;

        if(index.value == k){
            return node;
        }
        return next;
    }

}
class Index{
    int value;
}
class Node{
    int data;
    Node next;

    public Node() {
    }

    public Node(int data) {
        this.data = data;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}