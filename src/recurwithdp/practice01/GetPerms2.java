package recurwithdp.practice01;

import java.util.ArrayList;
import java.util.List;

class GetPerms2 {
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
        for (int i = 0; i < str.length(); i++) {
            char first = str.charAt(i);
            String before = str.substring(0, i);
            String after = str.substring(i + 1);
            List<String> words = getPerms(before + after);
            for (String word : words) {
                permutations.add(first + word);
            }
        }
        return permutations;

    }
}
