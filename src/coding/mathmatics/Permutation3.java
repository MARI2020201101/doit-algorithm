package coding.mathmatics;

import java.util.HashSet;
import java.util.Set;

class Permutation3 {
    static String abcd = "ABCD";

    public static void main(String[] args) {
        Set<String> permutation = permutation(new HashSet<>(), "", abcd);
        permutation.stream().forEach(System.out::println);
    }
    static Set<String> permutation(Set<String> set ,String text, String str){
        int len = str.length();
        if(len == 0){
            set.add(text);
            return set;
        }
        for (int i = 0; i < len; i++) {
            String s = String.valueOf(str.charAt(i));

            permutation(set, text.concat(s)
                    , str.replaceFirst(s, ""));
        }
        return set;
    }
}
