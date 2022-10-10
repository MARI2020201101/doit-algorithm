package datastructure.trie;

import java.util.HashMap;
import java.util.Map;

class Node {
    private Map<Character, Node> children = new HashMap<>();
    private boolean word;

    public void print(){
        children.forEach(
                (character, node) ->
                        node.print()
        );
    }

    @Override
    public String toString() {
        return children.keySet().toString();
    }

    Map<Character, Node> getChildren() {
        return children;
    }

    public boolean isWord() {
        return word;
    }

    public void setWord(boolean word) {
        this.word = word;
    }
}
