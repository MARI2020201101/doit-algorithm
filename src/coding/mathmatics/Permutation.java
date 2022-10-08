package coding.mathmatics;

class Permutation {
    static String abcd = "ABCD";
    static int N = abcd.length();

    public static void main(String[] args) {
        permutation("", abcd);
    }
    static void permutation(String text, String str){
        int len = text.length();
        if(len == 4){
            System.out.println(text);
            return;
        }
        for (int i = 0; i < N; i++) {
            char c = abcd.charAt(i);
            str.replaceFirst(String.valueOf(c), "");
            permutation(text.concat(String.valueOf(c)), str.substring(1));
        }
    }
}
