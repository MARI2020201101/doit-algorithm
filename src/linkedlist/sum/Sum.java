package linkedlist.sum;

class Sum {
    public static void main(String[] args) {
        Tree tree1 = new Tree(7);
        tree1.addNode(1);
        tree1.addNode(6);

        Tree tree2 = new Tree(5);
        tree2.addNode(9);
        tree2.addNode(2);

        Node node = sumNodes(tree1.root, tree2.root, 0);
        while(node!=null){
            System.out.print(node.data);
            node = node.next;
        }
    }
    static Node sumNodes(Node head1, Node head2, int carry){
        if(head1 == null && head2 == null && carry == 0){
            return null;
        }
        Node sum = new Node();
        int val = head1.data + head2.data + carry;
        sum.data = val % 10;
        carry = val / 10;
        Node result = sumNodes(head1.next, head2.next, carry);
        sum.next = result;

        return sum;
    }
}
