package bitoperation.updatebits;

class UpdateBits {
    public static void main(String[] args) {
        System.out.println(updateBits(64, 7, 2,4));
    }
    static int updateBits(int n, int m, int i, int j){
        int left = ~0;
        left <<= j+1;
        int right = ((1<<i)-1);
        int mask = left | right;
        int maskedN = n & mask;
        int shiftedM = m << i;
        return maskedN | shiftedM;
    }
}
