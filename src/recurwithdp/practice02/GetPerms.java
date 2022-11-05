package recurwithdp.practice02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class GetPerms {
    public static void main(String[] args) {
        String str = "aabbbbc";
        Map<Character, Integer> map = buildMap(str);
        List<String> list = new ArrayList<>();
        List<String> perms = getPerms(str.length(), "", map, list);
        perms.forEach(System.out::println);
    }

    private static Map<Character, Integer> buildMap(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char key = str.charAt(i);
            Integer count = map.getOrDefault(key, 0);
            map.put(key, ++count);
        }
        return map;
    }

    static List<String> getPerms(int len, String str, Map<Character, Integer> map, List<String> list){
        if(len == 0){
            list.add(str);
            return list;
        }
        for (Character key : map.keySet()) {
            Integer count = map.get(key);
            if(count > 0){
                map.put(key, count-1);
                getPerms(len-1, str + key, map, list);
                map.put(key, count);
            }
        }
        return list;
    }
}
