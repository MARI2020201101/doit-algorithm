package linkedlist.practice02;

class Demo {
    public static void main(String[] args) {
        Tree tree = new Tree(0);
        tree.addNode(1);
        tree.addNode(2);
        tree.addNode(3);
        tree.addNode(4);
        tree.addNode(5);
        Node node = tree.kthNode(tree.root ,2,new Index() );
        Node node2 = tree.kthNode(tree.root ,4,new Index() );
        System.out.println(node.data);
        System.out.println(node2.data);
    }
}
