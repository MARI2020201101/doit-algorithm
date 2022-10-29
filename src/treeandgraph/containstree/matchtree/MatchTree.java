package treeandgraph.containstree.matchtree;


class MatchTree {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.recurNode(5);
        tree.recurNode(4);
        tree.recurNode(3);
        tree.recurNode(2);
        tree.recurNode(1);
        tree.recurNode(6);
        tree.recurNode(7);
        tree.recurNode(8);
        tree.recurNode(9);

        Tree tree2 = new Tree();
        tree2.recurNode(3);
        tree2.recurNode(2);
        tree2.recurNode(1);

        Tree tree3 = new Tree();
        tree3.recurNode(8);
        tree3.recurNode(9);
        tree3.recurNode(10);
        System.out.println(subtree(tree.root, tree2.root));
        System.out.println(subtree(tree.root, tree3.root));

    }
    static boolean subtree(Node node1, Node node2){
        if(node1 == null) return false;
        if(node1.data == node2.data){
            return matchTree(node1, node2);
        }
        return subtree(node1.left, node2) || subtree(node1.right, node2);
    }

    private static boolean matchTree(Node node1, Node node2) {
        if(node1 == null && node2 == null) return true;
        if(node1 == null || node2 == null) return false;
        if(node1.data != node2.data) return false;
        return matchTree(node1.left, node2.left) && matchTree(node1.right, node2.right);
    }

}
