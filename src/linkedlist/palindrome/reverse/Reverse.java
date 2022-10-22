package linkedlist.palindrome.reverse;

class Reverse {
    public static void main(String[] args) {
        Tree tree = new Tree(1);
        tree.addNode(2);
        tree.addNode(3);
        tree.addNode(4);
        Node node = reverseNode(tree.root);
        while(node!=null){
            System.out.print(node.data);
            System.out.print("->");
            node =node.next;
        }
    }
    static Node reverseNode(Node node){
        Node head = null;
        while(node != null){
            Node n = new Node(node.data);
            n.next = head;
            head = n ;
            node = node.next;
        }
        return head;
    }
}
