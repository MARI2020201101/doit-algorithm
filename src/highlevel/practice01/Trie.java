package highlevel.practice01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
class Demo {
    public static void main(String[] args) {
        String big = "mississippi";
        String[] small = {"is","ppi","hi","sis","i","ssippi"};
        Trie trie = createTrieFromStr(big);
        for (int i = 0; i < small.length; i++) {
            List<Integer> search = trie.search(small[i]);
            if(search!=null) search.forEach(s-> System.out.print(s+" "));
            System.out.println();
        }
    }

    private static Trie createTrieFromStr(String big) {
        Trie trie = new Trie();
        for (int i = 0; i < big.length(); i++) {
            String str = big.substring(i);
            trie.insertStr(str, i);
        }
        return trie;
    }

}
class Trie {
    TrieNode root = new TrieNode();
    Trie(){}
    Trie(String str){
        root.insertStr(str, 0);
    }
    public void insertStr(String str, int index){
        root.insertStr(str, index);
    }
    public List<Integer> search(String str){
        return root.search(str);
    }
}
class TrieNode{
    Map<Character, TrieNode> children= new HashMap<>();
    List<Integer> indexes = new ArrayList<>();
    Character value;
    public List<Integer> search(String str){
        if(str == null || str.length() == 0){
            return indexes;
        }
        if(children.containsKey(str.charAt(0))){
            TrieNode child = children.get(str.charAt(0));
            return child.search(str.substring(1));
        }
        return null;
    }
    public void insertStr(String str, int index){
        indexes.add(index);
        if(str!=null && str.length()>0){
            char c = str.charAt(0);
            value = c;
            if(children.containsKey(c)){
                TrieNode child = children.get(c);
                child.insertStr(str.substring(1), index+1);
            }else{
                TrieNode child = new TrieNode();
                child.insertStr(str.substring(1), index+1);
                children.put(value, child);
            }
        }else{
            value = '\0';
            children.put(value, null);
        }
    }
    public boolean isLastStr(){
        return value == '\0';
    }

}
