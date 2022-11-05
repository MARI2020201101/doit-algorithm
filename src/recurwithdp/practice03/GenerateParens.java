package recurwithdp.practice03;

import java.util.HashSet;
import java.util.Set;

class GenerateParens {
    public static void main(String[] args) {
        Set<String> parens = generateParens(5);
        parens.forEach(System.out::println);
    }
    static Set<String> generateParens(int n){
        HashSet<String> set = new HashSet<>();
        if(n == 0){
            set.add("");
            return set;
        }
        Set<String> parens = generateParens(n - 1);
        for (String paren : parens) {
            for (int i = 0; i < paren.length(); i++) {
                if(paren.charAt(i) == '('){
                    String before = paren.substring(0, i+1);
                    String after = paren.substring(i+1);
                    set.add(before + "()" + after);
                }
            }
            set.add("()"+paren);
        }
        return set;
    }
}
