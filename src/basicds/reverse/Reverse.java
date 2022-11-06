package basicds.reverse;

class Reverse {
    public static void main(String[] args) {
        System.out.println(reverse(1132));
    }
    static int reverse(int x){
        int result = 0;
        while(x!=0){
            result = result*10 + x%10;
            x/=10;
        }
        return result;
    }
}
