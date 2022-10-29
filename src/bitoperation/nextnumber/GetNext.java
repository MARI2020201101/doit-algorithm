package bitoperation.nextnumber;

class GetNext {
    public static void main(String[] args) {
        System.out.println(getNext(13948));
    }
    static int getNext(int n){
        int num = n;
        int c0 = 0;
        int c1 = 0;

        while((num & 1) == 0){
            num>>=1;
            c0++;
        }
        while((num & 1) != 0){
            num>>=1;
            c1++;
        }
        int p = c0 + c1;

        n |= (1 << p);
        n &= -(1 << p);
        int zeros = (1 << (c1-1)) - 1;
        n |= zeros;
        return n;
    }
}
