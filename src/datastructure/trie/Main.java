package datastructure.trie;

class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("cat");
        trie.insert("caret");
        System.out.println(trie.contains("car"));
        trie.print();
    }
}
