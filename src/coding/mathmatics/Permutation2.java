package coding.mathmatics;

class Permutation2 {
    static String abcd = "ABCD";

    public static void main(String[] args) {
        permutation("", abcd);
    }
    static void permutation(String text, String str){
        int len = str.length();
        if(len == 0){
            System.out.println(text);
            return;
        }
        for (int i = 0; i < len; i++) {
            String s = String.valueOf(str.charAt(i));

            permutation(text.concat(s)
                    , str.replaceFirst(s, ""));
        }
    }
}
