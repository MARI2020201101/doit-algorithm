package recurwithdp.generateparens;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class GenerateParens2 {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        int size = 3;
        char[] parens = new char[size*2];
        generateParens(0,size,size,parens,set);
//        set.forEach(System.out::println);
    }
    static void generateParens(int index, int left, int right, char[] parens, Set<String> set){
        if(left < 0 || left > right) return;
        if(left == 0 && right == 0) {
            set.add(String.copyValueOf(parens));
            return;
        }
        System.out.println(Arrays.toString(parens));
        parens[index] = '(';
        generateParens(index+1, left-1, right, parens, set);
        parens[index] = ')';
        generateParens(index+1, left, right-1, parens, set);

    }
}
