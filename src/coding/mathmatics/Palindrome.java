package coding.mathmatics;

class Palindrome {
    public static void main(String[] args) {
        System.out.println(palindrome("madam"));
        System.out.println(palindrome("madame"));
    }

    static boolean palindrome(String str){
        int start = 0;
        int end = str.length() -1 ;
        while(start<=end){
            if(str.charAt(start) != str.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}
