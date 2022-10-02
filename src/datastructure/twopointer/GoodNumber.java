package datastructure.twopointer;

class GoodNumber {
    public static void main(String[] args) {
        System.out.println(count());
    }
    static int[] arr = {1,2,3,4,5,6,7,8,9,10};
    static int count(){
        int cnt =0;
        int target = arr.length-1;
        int start = 0;
        int end = target-1;
        while(target>0){
            int n = arr[target];
            int sum = arr[start] + arr[end];
            System.out.println(String.format("n=%d, start=%d, end=%d, sum=%d", n,start,end,sum));
            if(start != end && sum == n){
                cnt++;
                target--;
                start = 0;
                end = target-1;
            }else if(sum < n){
                start++;
            }else if(start == end){
                target--;
            }
        }
        return cnt;
    }
}
