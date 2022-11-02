package dynamicprogramming.leavecompany;

import java.util.Arrays;

class LeaveCompany4 {
    static int[] price = {0,10,20,10,20,15,40,200};
    static int[] time = {0,3,5,1,1,2,4,2};
    static int N = 8;
    static int[] answer = new int[N];

    public static void main(String[] args) {
        solve();
        System.out.println(Arrays.toString(answer));
    }
    static void solve(){
        for (int i = 1; i < answer.length-1; i++) {
            if(i+time[i] < answer.length){
                answer[i+time[i]] = Math.max(answer[i+time[i]], price[i]+answer[i]);
            }
        }
    }
}
