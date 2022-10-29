package bitoperation.nextnumber;

class GetPrev {
    public static void main(String[] args) {
        System.out.println(getPrev(13948));
    }
    static int getPrev(int n){
        int num = n ;
        int c0 = 0;
        int c1 = 0;
        while((num & 1) == 1 && num != 0){
            c1++;
            num>>>=1;
        }
        while((num & 1)==0 && num != 0){
            c0++;
            num>>>=1;
        }
        int p = c1 + c0;
        n &= (~0 << (p + 1));
        int mask = (1 << (c1 + 1)) - 1;
        mask <<= c0-1;
        n |= mask;
        return n;
    }
}
