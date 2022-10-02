package datastructure.twopointer;

class TwoPointer {
    public static void main(String[] args) {
        System.out.println(count(15));
    }
    static int count(int n){
        int start = 1;
        int end = n-1;
        int cnt = 0;
        while(start < end){
            int len = end-start+1;
            if((start+end)/2*len==n) {
                cnt++;
            }
                start+=1;
                end-=1;
        }
        return cnt;
    }
}
