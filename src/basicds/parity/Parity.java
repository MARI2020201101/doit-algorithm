package basicds.parity;

class Parity {
    public static void main(String[] args) {
        System.out.println(parity(20));
        System.out.println(parity(28));
    }
    static int parity(int x){
        int num = x;
        int count = 0;
        while(num!=0){
            num &= num-1;
            count^=1;
        }
        return count;
    }
}
