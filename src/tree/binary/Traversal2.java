package tree.binary;

import java.util.Arrays;

class Traversal2 {
    static int N = 8;
    static char[] nodes = new char[N];
    static int idx = 1;

    public static void main(String[] args) {
        nodes[1] = 'A';
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
        for (int j = 0; j < nodes.length; j++) {
            if(nodes[j] == s.charAt(i)) {
                root = j;
            }
        }
        i++;
        root*=2;
        while(s.charAt(i)!='.' && root < N){
            System.out.println("root = "+ root + " , = "+ s.charAt(i));
            nodes[root++] = s.charAt(i);
        }
    }

}
