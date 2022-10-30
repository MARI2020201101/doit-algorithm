package bitoperation.bitswaprequired;

class BitSwapRequired {
    public static void main(String[] args) {
        System.out.println(bitSwapRequired(29,15));
        System.out.println(bitSwapRequired2(29,15));
    }
    static int bitSwapRequired(int a, int b){
        int count = 0;
        for (int c = a^b; c > 0 ; c >>= 1) {
            count += c & 1;
        }
        return count;
    }
    static int bitSwapRequired2(int a, int b){
        //최하위비트를 뒤집어 나간다.
        int count = 0;
        for (int c = a^b; c > 0 ; c &= (c-1)) {
            System.out.println("c = " +c);
            count++;
        }
        return count;
    }
}
