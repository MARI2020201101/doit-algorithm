package coding.mathmatics;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

class FirstNonRepeatedStr {
    public static void main(String[] args) {
        search("abcdfgqwerqwerjklasdasdcvniirrrrnfjddiuytrewq");
    }
    static void search(String str){
        Map<Character, Long> map = new LinkedHashMap<>();

        for(Character c : str.toLowerCase(Locale.ROOT).toCharArray()){
            map.compute(c, (k,v) -> v == null ? 1L : ++v);
        }
        map.forEach((k,v)-> System.out.println(k + " : "+ v+"개"));

    }
}
