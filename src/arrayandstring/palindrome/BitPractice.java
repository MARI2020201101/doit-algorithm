package arrayandstring.palindrome;

class BitPractice {
    public static void main(String[] args) {
        System.out.println(getBit(4,2));
        System.out.println(setBit(10,2));
        System.out.println(clearBit(6,2));
        System.out.println(clearBitsBottomI(10,2));
        System.out.println(clearBitsTopI(10,2));
        System.out.println(updateBit(10,2));
    }
    static boolean getBit(int num, int i){
        return (num &(1<<i)) != 0;
    }
    static int setBit(int num, int i){
        return num | (1 <<i);
    }
    static int clearBit(int num, int i){
        int mask = ~(1 << i);
        return num & mask;
    }
    static int clearBitsBottomI(int num, int i){
        int mask = (1 << i) - 1;
        return num & mask;
    }
    static int clearBitsTopI(int num, int i){
        int mask = (-1 << (i+1));
        return num & mask;
    }
    static int updateBit(int num, int i){
        int mask = ~(1 << i);
        return (num & mask) | (1 << i);
    }
}
