package tree.binary;

class Traversal4 {

    static int[][] tree = new int[26][2];

    public static void main(String[] args) {
        insert("ABC");
        insert("BD.");
        insert("CEF");
        insert("E..");
        insert("F.G");
        insert("D..");
        insert("G..");
        preOrder(0);
        System.out.println();
        inOrder(0);
        System.out.println();
        postOrder(0);
    }
    static void preOrder(int start){
        if(start == -1) return;
        char c = (char) (start + 'A');
        System.out.print(c);
        preOrder(tree[start][0]);
        preOrder(tree[start][1]);
    }
    static void inOrder(int start){
        if(start == -1) return;
        char c = (char) (start + 'A');
        inOrder(tree[start][0]);
        System.out.print(c);
        inOrder(tree[start][1]);
    }
    static void postOrder(int start){
        if(start == -1) return;
        char c = (char) (start + 'A');
        postOrder(tree[start][0]);
        postOrder(tree[start][1]);
        System.out.print(c);
    }
    static void insert(String str){
        int idx = str.charAt(0) - 'A';
        char left = str.charAt(1);
        char right = str.charAt(2);
        if(left!='.'){
            tree[idx][0] = left-'A';
        }else{
            tree[idx][0] = -1;
        }
        if(right!='.'){
            tree[idx][1] = right-'A';
        }else{
            tree[idx][1] = -1;
        }
    }
}
