package recurwithdp.getperms;

import java.util.ArrayList;
import java.util.List;

class GetPerms3 {
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
        for (int i = 0; i < str.length(); i++) {
            String before = str.substring(0, i);
            char c = str.charAt(i);
            String after = str.substring(i+1);
            List<String> words = getPerms(before+after);
            for (String word: words) {
                permutations.add(word + c);
            }
        }
        return permutations;
    }
}
