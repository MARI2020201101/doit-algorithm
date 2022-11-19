package highlevel.practice01;

import java.util.List;

public class Demo2 {
    public static void main(String[] args) {
        String big = "mississippi";
        String[] small = {"is","ppi","hi","sis","i","ssippi"};
        Trie trie = createTrieFromStr(small);
        getIndexes(big, trie);

    }
    public static void getIndexes(String big, Trie trie){
        for (int start = 0; start <= big.length(); start++) {
            for (int end = start; end <= big.length(); end++) {
                String str = big.substring(start, end);
                List<Integer> list = trie.search(str);
                if(list!=null) {
                    System.out.println(str);
                    list.forEach(e-> System.out.print(e+ " "));
                    System.out.println();
                }

            }
        }
    }
    private static Trie createTrieFromStr(String[] small) {
        Trie trie = new Trie();
        for (int i = 0; i < small.length; i++) {
            trie.insertStr(small[i], 0);
        }
        return trie;
    }
}
