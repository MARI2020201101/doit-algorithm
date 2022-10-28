package treeandgraph.sorted.minmax;

class MinMax {
    public static void main(String[] args) {
        Node root1 = sampleRootNode();
        Node root2 = sampleSortedRootNode();
        System.out.println(isBST(root1));
        System.out.println(isBST(root2));
    }

    static boolean isBST(Node node){
        return isBST(node,null,null);
    }
    private static boolean isBST(Node node, Integer min, Integer max){
        if(node == null) return true;

        isBST(node.left, min, node.data);
        isBST(node.right, node.data, max);

        boolean largerThanMin = true;
        boolean smallerThanMax = true;

        if(min!=null && min > node.data) {
            largerThanMin = false;
        }
        if(max!=null && max <= node.data) {
            smallerThanMax = false;
        }

        return largerThanMin && smallerThanMax;
    }
    private static Node sampleSortedRootNode() {
        Node root = new Node(10);
        root.addLeft(4);
        root.addLeft(3);
        root.addRight(20);
        Node node1 = new Node(2);
        node1.addLeft(1);
        node1.addRight(6);
        node1.addRight(7);
        root.addLeft(node1);
        return root;
    }
    private static Node sampleRootNode() {
        Node root = new Node(10);
        root.addLeft(4);
        root.addLeft(3);
        root.addRight(20);
        Node node1 = new Node(5);
        node1.addLeft(2);
        node1.addRight(6);
        node1.addRight(7);
        root.addLeft(node1);
        return root;
    }
}
