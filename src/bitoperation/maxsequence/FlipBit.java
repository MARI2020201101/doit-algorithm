package bitoperation.maxsequence;

class FlipBit {
    public static void main(String[] args) {
        System.out.println(flipBit(1775));
    }
    static int flipBit(int n){
        int maxLength = 0;
        int prevCount = 0;
        int currentCount = 0;
        while(n!=0){
            if((n & 1) == 1){
                currentCount++;
            }else{
                prevCount = (n & 2) == 0 ? 0 : currentCount;
                currentCount = 0;
            }
            n>>>=1;
            maxLength = Math.max(prevCount + 1 + currentCount, maxLength);
        }
        return maxLength;
    }
}
