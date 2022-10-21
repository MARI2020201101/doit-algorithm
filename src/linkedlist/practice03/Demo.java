package linkedlist.practice03;

class Demo {
    public static void main(String[] args) {
        Tree tree = new Tree(0);
        tree.addNode(1);
        tree.addNode(2);
        tree.addNode(3);
        tree.addNode(4);
        tree.addNode(5);
        tree.addNode(6);
        tree.addNode(7);
        tree.addNode(8);
        tree.addNode(9);
        tree.addNode(10);
        Node node = tree.kthNode(3);
        System.out.println(node.data);

    }
}
