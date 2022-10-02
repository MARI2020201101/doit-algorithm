package datastructure.twopointer;

class TwoPointer3 {
    public static void main(String[] args) {
        System.out.println(count(15));
    }
    static int count(int n){
        int start = 1;
        int end = start+1;
        int cnt=1;
        while(start<end && end < n/2+2){
            int sum = (start + end) * (end-start+1) / 2;
            System.out.println(String.format("sum=%d, start=%d, end=%d",sum,start,end));
            if(sum==n) {
                cnt++;
                start+=1;
                end=start+1;
            } else if(sum < n){
                end++;
            } else{
                start+=1;
                end=start+1;
            }
        }
        return cnt;
    }
}
