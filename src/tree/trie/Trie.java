package tree.trie;

class Trie {
    static Node root = new Node();

    public static void main(String[] args) {
        insert("cat");
        System.out.println(contains("cat"));
        System.out.println(contains("coat"));
        System.out.println(contains("c"));
    }
    static boolean contains(String str){
        int n = str.length()-1;
        boolean contains = false;
        while(n > 0){
            char c = str.charAt(n);
            if(root.nodes[c-'a'] == null){
                break;
            }
            n--;
            if(n==0 && root.nodes[c - 'a'].isEnd) contains = true;
        }
        return contains;
    }
    static void insert(String str){
        int n = str.length()-1;
        while(n > 0){
            char c = str.charAt(n);
            if(root.nodes[c-'a'] == null){
                root.nodes[c-'a'] = new Node();
            }
            n--;
            if(n==0) root.nodes[c-'a'].isEnd = true;
        }
    }

}
class Node{
    Node[] nodes = new Node[26];
    boolean isEnd;

}