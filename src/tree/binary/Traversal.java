package tree.binary;

import java.util.Arrays;

class Traversal {
    static int N = 8;
    static char[] nodes = new char[N];
    static int idx = 1;

    public static void main(String[] args) {
        insert("ABC");
        insert("BD.");
        insert("CEF");
        insert("E..");
        insert("F.G");
        insert("D..");
        insert("G..");
        System.out.println(Arrays.toString(nodes));
    }
    static void insert(String s){
        int i = 0;
        int root = idx;
        nodes[root] = s.charAt(i++);
        root*=2;

        while(s.charAt(i)!='.' && root < N){
            nodes[root++] = s.charAt(i);
        }
        idx++;
    }

}
