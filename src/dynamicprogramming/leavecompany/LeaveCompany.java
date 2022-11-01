package dynamicprogramming.leavecompany;

class LeaveCompany {
    static int N = 8;
    static Consulting[] arr = new Consulting[N];
    static int max = 0;

    public static void main(String[] args) {
        init();
        dfs(1, 0);
        System.out.println(max);
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
    static int dfs(int k, int value){
        if(k >= N) {
            return value;
        }

        for (int i = k; i < N; i++) {
            max = Math.max(max, dfs(k+arr[k].time, value+arr[k].value));
        }
        return max;
    }
}
class Consulting {
    int time;
    int value;

    public Consulting(int time, int value) {
        this.time = time;
        this.value = value;
    }
}