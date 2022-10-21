package tree.binary;

class Traversal3 {

    static int[][] tree = new int[26][2];

    public static void main(String[] args) {
        insert("ABC");
        insert("BD.");
        insert("CEF");
        insert("E..");
        insert("F.G");
        insert("D..");
        insert("G..");
        print(0);
    }
    static void print(int start){
        if(start == -1) return;
        char c = (char) (start + 'A');
        System.out.print(c);
        print(tree[start][0]);
        print(tree[start][1]);
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
