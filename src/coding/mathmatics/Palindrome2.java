package coding.mathmatics;

class Palindrome2 {
    public static void main(String[] args) {
        System.out.println(palindrome("madam"));
        System.out.println(palindrome("madame"));
    }
    static boolean palindrome(String str){
        int len = str.length();
        for (int i = 0; i < len; i++) {
            if(str.charAt(i)!=str.charAt(len-i-1)) return false;
        }
        return true;
    }
}
