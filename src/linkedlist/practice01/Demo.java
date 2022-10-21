package linkedlist.practice01;

class Demo {
    public static void main(String[] args) {
        Tree tree = new Tree(0);
        tree.addNode(1);
        tree.addNode(2);
        tree.addNode(3);
        tree.addNode(4);
        tree.printNode();
        System.out.println(tree.printKthNode(tree.root, 1));
    }
}
