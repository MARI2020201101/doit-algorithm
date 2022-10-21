package tree.tree;

class LeafNode6 {
    static int N = 9;
    static int D = 4;
    static MyNode[] nodes = new MyNode[N];
    static int ans = 0;
    static {
        for (int i = 0; i < N; i++) {
            nodes[i] = new MyNode(i);
        }
        nodes[0].addChild(new MyNode(1), new MyNode(2));
        nodes[2].addChild(new MyNode(3), new MyNode(4));
        nodes[4].addChild(new MyNode(5), new MyNode(6));
        nodes[6].addChild(new MyNode(7), new MyNode(8));
    }

    public static void main(String[] args) {
        int root = 0;
        if (D != root) {
            deleteNode(root);
            dfs(root);
        }
        System.out.println(ans);
    }



    static void deleteNode(int idx) {
        for(MyNode child : nodes[idx].child) {
            if(child.idx == D) {
                nodes[idx].child.remove(child);
                return;
            }
            deleteNode(child.idx);
        }
    }

    static void dfs(int idx) {
        if (nodes[idx].child.size() == 0) {
            ans++;
            return;
        }

        for(MyNode child : nodes[idx].child) {
            dfs(child.idx);
        }
    }
}
