package recurwithdp.duplicateperms;

import java.util.*;

class GetPerms {
    public static void main(String[] args) {
        String str = "aabbbbc";
        List<String> perms = getPerms(str);
        perms.forEach(System.out::println);
    }
    static List<String> getPerms(String str){
        Map<Character,Integer> map = new HashMap<>();
        Map<Character, Integer> characterMap = buildMap(str, map);
        characterMap.forEach((k,v)-> System.out.println(k + " : " + v));
        List<String> list = new ArrayList<>();
        return __getPerms("", str.length(), characterMap, list);
    }

    private static List<String> __getPerms(String str, int len, Map<Character, Integer> map, List<String> list) {
        if(len == 0){
            list.add(str);
            return list;
        }
        for(Character c : map.keySet()){
            Integer count = map.get(c);
            map.put(c, count-1);
            __getPerms(str + c,len-1, map, list);
            map.put(c, count);
        }
        return list;
    }

    private static Map<Character,Integer> buildMap(String str, Map<Character, Integer> map) {
        for (int i = 0; i < str.length(); i++) {
            Integer count = map.getOrDefault(str.charAt(i),0);
            map.put(str.charAt(i), ++count);
        }
        return map;
    }
}
