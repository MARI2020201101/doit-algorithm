package coding.mathmatics;

import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

class CountStr {
    public static void main(String[] args) {
        count("abcdfgqwerqwerjklasdasdcvniirrrrnfjddiuytrewq");
    }
    static void count(String str){
        HashMap<String, Long> map = str.toLowerCase(Locale.ROOT)
                .chars()
                .mapToObj(c-> String.valueOf(Character.toChars(c)))
                .collect(groupingBy(c->c, HashMap::new, counting()));


        boolean a = map.containsKey("a");
        System.out.println(a);
        map.forEach((k,v)-> System.out.println(k + " : "+ v+" 개"));
    }
}
