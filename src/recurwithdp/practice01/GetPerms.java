package recurwithdp.practice01;

import java.util.ArrayList;
import java.util.List;

class GetPerms {
    public static void main(String[] args) {
        String str = "abcde";
        List<String> perms = getPerms(str);
        perms.forEach(System.out::println);
    }
    static List<String> getPerms(String str){
        List<String> permutations = new ArrayList<>();
        if(str.length() == 0) {
            permutations.add("");
            return permutations;
        }
        String first = str.substring(0, 1);
        List<String> words = getPerms(str.substring(1));
        for (String word : words) {
            for (int i = 0; i <= word.length(); i++) {
                String s = insertCharAt(word, i, first);
                permutations.add(s);
            }
        }
        return permutations;
    }

    private static String insertCharAt(String word, int i, String first) {
        String before = word.substring(0, i);
        String after = word.substring(i);
        return before + first + after;
    }
}
