package datastructure.trie;

import java.util.Map;

class Trie {
    private Node root;
    public Trie(){
        this.root = new Node();
    }
    public void print(){
        Node node = root;

        for (Node child: node.getChildren().values()) {
            child.print();
        }


    }
    public void insert(String word){
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            node = node.getChildren().computeIfAbsent(ch, k -> new Node());
        }
        node.setWord(true);
    }
    public boolean contains(String word){
        Node node=root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            node = node.getChildren().get(ch);
            if(node == null) return false;
        }
        return node.isWord();
    }
    public boolean delete(String word){
        return delete(root, word, 0);
    }

    private boolean delete(Node node, String word, int position) {
        if(word.length() == position){
            if(! node.isWord()){
                return false;
            }
            node.setWord(false);
            return node.getChildren().isEmpty();
        }
        char ch = word.charAt(position);
        Node children = node.getChildren().get(ch);

        if(children == null) return false;
        boolean deleteChildren = delete(children, word, position+1);
        if(deleteChildren && !children.isWord()){
            node.getChildren().remove(ch);
            return node.getChildren().isEmpty();
        }
        return false;
    }
}
