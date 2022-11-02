package dynamicprogramming.leavecompany;

import java.util.Arrays;

class LeaveCompany2 {
    static int N = 8;
    static Consulting[] arr = new Consulting[N];
    static int[] answer = new int[N];

    public static void main(String[] args) {
        init();
        solve();
        System.out.println(Arrays.toString(answer));
    }
    static void init(){
        arr[0] = new Consulting(0,0);
        arr[1] = new Consulting(3,10);
        arr[2] = new Consulting(5,20);
        arr[3] = new Consulting(1,10);
        arr[4] = new Consulting(1,20);
        arr[5] = new Consulting(2,15);
        arr[6] = new Consulting(4,40);
        arr[7] = new Consulting(2,200);
    }
    static void solve(){

        for (int i = 1; i < answer.length; i++) {
                if(i + arr[i].time < N){
                    answer[i+arr[i].time] = Math.max(answer[i+arr[i].time], answer[i] + arr[i].value);
            }

        }
    }
}
