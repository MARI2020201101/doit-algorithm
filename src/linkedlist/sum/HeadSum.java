package linkedlist.sum;

class HeadSum {
    public static void main(String[] args) {
        Tree tree1 = new Tree(1);
        tree1.addNode(2);
        tree1.addNode(3);
        tree1.addNode(4);

        Tree tree2 = new Tree(5);
        tree2.addNode(6);
        tree2.addNode(7);

        Node node = sumNodes(tree1.root, tree2.root);

        while(node!=null){
            System.out.print(node.data);
            node = node.next;
        }
    }
    static Node sumNodes(Node head1, Node head2){
        int c1 = countNodes(head1);
        int c2 = countNodes(head2);
        int count = Math.abs(c2-c1);
        if(c1 < c2){
            head1 = insertZeroHead(head1, count);
        }else if(c1 > c2){
            head2 = insertZeroHead(head2, count);
        }
        PartialSum sum = addNodes(head1, head2);
        return sum.sum;
    }
    static PartialSum addNodes(Node head1, Node head2){
        if(head1 == null && head2 == null){
            return new PartialSum();
        }
        PartialSum sum = addNodes(head1.next, head2.next);
        int value = head1.data + head2.data + sum.carry;

        Node node = insertHeadNode(sum.sum, value);
        PartialSum result = new PartialSum();
        node.data = value % 10;
        result.sum = node;
        result.carry = value / 10;

        return result;
    }
    static Node insertHeadNode(Node list, int value){
        Node node = new Node(value);
        if(list != null){
            node.next = list;
        }
        return node;
    }
    static Node insertZeroHead(Node node, int count){
        Node n = null;
        while(count > 0){
            n = new Node(0);
            n.next = node;
            node = n;
            count--;
        }
        return n;
    }
    static int countNodes(Node node){
        int count = 0;
        while(node!=null){
            count++;
            node = node.next;
        }
        return count;
    }
}
class PartialSum {
    Node sum = null;
    int carry;
}