package tree.binary;

class TreeTraversal {
    static int[][] tree = new int[26][2];

    static int NOPE = -1;
    static void init(){
        for (int i = 0; i < tree.length; i++) {
            for (int j = 0; j < tree[0].length; j++) {
                tree[i][j] = NOPE;
            }
        }
    }

    static void insert(String str){
        int parent = str.charAt(0) - 'A';
        char lChild = str.charAt(1);
        char rChild = str.charAt(2);
        if(lChild != '.'){
            tree[parent][0] = lChild-'A';
        }
        if(rChild != '.'){
            tree[parent][1] = rChild-'A';
        }
    }
    static void preorder(int now){
        if(now == -1) return;
        System.out.print((char)('A' + now));
        preorder(tree[now][0]);
        preorder(tree[now][1]);
    }
    public static void main(String[] args) {
        insert("ABC");
        insert("BD.");
        insert("CEF");
        insert("E..");
        insert("F.G");
        insert("D..");
        insert("G..");

        preorder(0);
    }
}
