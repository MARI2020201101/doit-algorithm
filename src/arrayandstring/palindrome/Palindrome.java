package arrayandstring.palindrome;

class Palindrome {

    public static void main(String[] args) {
        System.out.println(palindrome("abcba"));
        System.out.println(palindrome("abbad"));
    }
    static int charToIntVal(char c){
        if(c >= 'a' && c <= 'z'){
            System.out.println(c - 'a' + 1);
            return c - 'a' + 1;
        }
        else return -1;
    }
    static boolean palindrome(String str){
        int bit = 0;
        for(char c : str.toCharArray()){
            int x = charToIntVal(c);
            bit = toggle(bit, x);
        }
        return isPalindrome(bit);
    }

    private static boolean isPalindrome(int bit){
        int x = bit - 1;
        return (bit==0) || ((bit & x)==0);
    }
    private static int toggle(int bit, int x) {
        int mask = 1 << x;
        if((bit & mask)==0){
            bit |= mask;
        }else{
            bit &=~mask;
        }
        return bit;
    }
}
