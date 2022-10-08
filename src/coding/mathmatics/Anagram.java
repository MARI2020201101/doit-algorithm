package coding.mathmatics;

import java.util.Arrays;

class Anagram {
    public static void main(String[] args) {
        System.out.println(anagram("hello","oehll"));
        System.out.println(anagram("hello","oegll"));
    }

    static boolean anagram(String a, String b){
        if(a.length()!=b.length()) return false;

        int[] chars = new int[256];
        char[] chars1 = a.toCharArray();
        char[] chars2 = b.toCharArray();
        for(int i=0; i< a.length() ; i++){
            chars[chars1[i]]++;
            chars[chars2[i]]--;
        }
        for (int i = 0; i < chars.length; i++) {
            if(chars[i]!=0) return false;
        }
        return true;
    }
}
