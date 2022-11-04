package recurwithdp.getperms;

import java.util.ArrayList;
import java.util.List;

class GetPerms {
    public static void main(String[] args) {
        String str = "abcd";
        List<String> perms = getPerms(str.length() , str);
        perms.forEach(System.out::println);
    }
    static List<String> getPerms(int i, String str){
        if(i < 0) {
            List<String> permutations = new ArrayList<>();
            permutations.add(str);
            return permutations;
        }
        List<String> list = new ArrayList<>();

        char c = str.charAt(i);
        String remain = str.substring(0, i-1);
        list = getPerms(i-1, remain);
        for (int j = 0; j < list.size(); j++) {
            list.addAll(insertCharAt(list.get(j),c));
        }

        return list;
    }

    private static List<String> insertCharAt(String str, char c) {
        List<String> list = new ArrayList<>();
        String before = c + str;
        String after = str + c;
        list.add(before);
        list.add(after);
        return list;
    }
}
