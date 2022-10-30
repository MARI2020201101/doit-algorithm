package bitoperation.swapoddevenbits;

class SwapOddEvenBits {
    public static void main(String[] args) {
        System.out.println(0xaaaaaaaa);
        System.out.println(0x55555555);
        System.out.println(swapOddEvenBits(10));
    }
    static int swapOddEvenBits(int x){
        return ((x & 0xaaaaaaaa)>>>1) | ((x & 0x55555555) << 1);
    }
}
