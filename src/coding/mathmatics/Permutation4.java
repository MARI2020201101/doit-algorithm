package coding.mathmatics;

import java.util.HashSet;
import java.util.Set;

class Permutation4 {
    static String abcd = "ABCD";

    public static void main(String[] args) {
        Set<String> permutation = permutation("", abcd);
        permutation.forEach(System.out::println);
    }
    static Set<String> permutation(String text, String str){
        Set<String> permutaions = new HashSet<>();
        int len = str.length();
        if(len == 0){
            permutaions.add(text);
            return permutaions;
        }
        for (int i = 0; i < len; i++) {
            String s = String.valueOf(str.charAt(i));

            permutaions.addAll(permutation(text.concat(s)
                    , str.replaceFirst(s, "")));
        }
        return permutaions;
    }
}
