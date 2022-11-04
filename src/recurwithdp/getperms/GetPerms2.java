package recurwithdp.getperms;

import java.util.ArrayList;
import java.util.List;

class GetPerms2 {
    public static void main(String[] args) {
        String str = "abcde";
        List<String> perms = getPerms(str);
        perms.forEach(System.out::println);
    }
    static List<String> getPerms(String str){
        if(str == null) return null;
        List<String> permutations = new ArrayList<>();
        if(str.length() == 0){
            permutations.add("");
            return permutations;
        }
        char first = str.charAt(0);
        String remain = str.substring(1);
        List<String> words = getPerms(remain);
        for (String word : words) {
            for (int i = 0; i <= word.length(); i++) {
                String newStr = insertCharAt(word, i, first);
                permutations.add(newStr);
            }
        }
        return permutations;
    }

    private static String insertCharAt(String word, int i, char first) {
        String before = word.substring(0, i);
        String after = word.substring(i);
        return before + first + after;
    }
}
