package basicds.palindrome;

class Palindrome {
    public static void main(String[] args) {
        System.out.println(palindrome(157751));
        System.out.println(palindrome(151751));
    }

    static boolean palindrome(int x){
        int len =(int) Math.floor(Math.log10(x));
        int divide = (int) Math.pow(10, len);

        int num = x;
        while(num!=0){
            int first = num / divide;
            int last = num % 10;
            System.out.println(String.format("first=%d, last=%d", first,last));
            if(first!=last) return false;
            num%=divide;
            num/=10;
            divide/=100;
        }
        return true;
    }
}
