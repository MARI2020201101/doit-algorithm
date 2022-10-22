package linkedlist.sum;

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


    public Node partition(int x){
        Node beforeStart = null;
        Node afterStart = null;
        Node beforeEnd = null;
        Node afterEnd = null;

        Node node = root;
        while(node != null){
            Node next = node.next;

            if(node.data < x){
                if(beforeStart == null){
                    beforeStart = node;
                    afterStart = node;
                }else{
                    afterStart = node;
                    afterStart.next = node;
                }
            }else{
                if(beforeEnd == null){
                    beforeEnd = node;
                    afterEnd = node;
                }else{
                    afterEnd = node;
                    afterEnd.next = node;
                }
            }
            node = next;
        }
        if(beforeStart == null) return beforeEnd;
        afterStart.next = beforeEnd;
        return beforeEnd;
    }
    public Node kthNode(int k){
        Node p1 = root;
        Node p2 = root;
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }
        while(p1.next != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
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