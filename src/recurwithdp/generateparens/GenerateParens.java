package recurwithdp.generateparens;

import java.util.HashSet;
import java.util.Set;

class GenerateParens {
    static Set<String> generateParens(int remain){
        Set<String> result = new HashSet<>();
        if (remain == 1){
            result.add("()");
            return result;
        }
        Set<String> parens = generateParens(remain - 1);
        for (String paren : parens) {

        }
        return null;
    }
}
