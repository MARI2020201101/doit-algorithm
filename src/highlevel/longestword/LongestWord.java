package highlevel.longestword;

import java.util.HashMap;
import java.util.Map;

class LongestWord {
    static String[] strs = {"cat","banana","dog","nana","walk","walker", "dogwalker"};

    public static void main(String[] args) {
        longestWord(strs);
    }
    static void longestWord(String[] strs){
        Map<String, Boolean> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            map.put(strs[i], true);
        }
        for (int i = 0; i < strs.length; i++) {
            if(longestWord(strs[i], true, map)){
                System.out.println(strs[i]);
            }
        }
    }
    static boolean longestWord(String str, boolean isOriginalWord, Map<String,Boolean> map){
        if(map.containsKey(str) && !isOriginalWord){
            return map.get(str);
        }
        for (int i = 1; i < str.length(); i++) {
            String first = str.substring(0, i);
            String remain = str.substring(i);
            if(map.containsKey(first) && map.get(first) && longestWord(remain, false, map)){
                return true;
            }
        }
        map.putIfAbsent(str, false);
        return false;
    }
}
