package highlevel.searchall;

import java.nio.charset.StandardCharsets;
import java.util.*;

class SearchAll {
    public static void main(String[] args) {
        String big = "mississippi";
        String[] small = {"is","ppi","hi","sis","i","ssippi"};
        Trie trie = createTrieFromString(big);
        trie.getRoot().print(0);
        for (int i = 0; i < small.length; i++) {
            List<Integer> indexes = trie.search(small[i]);
            if(indexes!=null)indexes.forEach(System.out::println);
        }
    }
    static Trie createTrieFromString(String str){
        Trie trie = new Trie();
        for (int i = 0; i < str.length(); i++) {
            String remain = str.substring(i);
            trie.insertAt(remain, i);
        }
        return trie;
    }
}
class Trie{
    TrieNode root = new TrieNode();
    public Trie(){}
    public Trie(String str){
        root.insert(str, 0);
    }

    public TrieNode getRoot() {
        return root;
    }
    public void insertAt(String str, int location){
        root.insert(str, location);
    }
    public List<Integer> search(String target){
        return root.search(target);
    }
}
class TrieNode{
    Map<Character, TrieNode> children = new HashMap<>();
    List<Integer> indexes = new ArrayList<>();
    Character value;
    public void insert(String str, int index){
        indexes.add(index);
        if(str == null || str.length() == 0){
            children.put('\0', null);
        }else{
            value = str.charAt(0);
            TrieNode child = null;
            if(children.containsKey(value)){
                child = children.get(value);
            }else{
                child = new TrieNode();
                children.put(value, child);
            }
            String remain = str.substring(1);
            child.insert(remain, index+1);
        }
    }

    public void print(int tab){
        for (int i = 0; i < tab; i++) {
            System.out.print(" ");
        }
        System.out.println(value);

        for(TrieNode child : children.values()){
            if(child!=null)child.print(tab+1);
        }
    }
    public List<Integer> search(String str){
        if(str == null || str.length() == 0){
            System.out.println(indexes);
            return indexes;
        }
        else{
            char value = str.charAt(0);
            if(children.containsKey(value)){
                TrieNode child = children.get(value);
                child.search(str.substring(1));
            }
        }
        return null;
    }
    public boolean terminates(){
        return children.containsKey('\0');
    }
}