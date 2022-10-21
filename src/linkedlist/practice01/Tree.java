package linkedlist.practice01;

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
    public int printKthNode(Node node, int k){
        if(node == null){
            return 0;
        }
        if(k == printKthNode(node.next, k)+1){
            return node.data;
        }
        return printKthNode(node.next, k) + 1 ;
    }


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