package dynamicprogramming.travelingsalesman;

class DpTsp {
    static int N = 4;
    static int[][] arr = {
            {0,10,15,20},
            {5,0,9,10},
            {6,13,0,12},
            {8,8,9,0},
    };
    static int[][] dp = new int[N][(int)Math.pow(2,N)];

    public static void main(String[] args) {
        init();
        tsp(0,1);
        //v : 초기값, 아무런 도시도 방문하지 않은 상태
        //n : 시작도시
        print(dp);
    }
    static int tsp(int n, int v){
        if(v == (1<<N)-1){
            //돌아갈 수 있다면
            return arr[n][0] == 0 ? Integer.MAX_VALUE : arr[n][0];
        }
        if(dp[n][v]!=Integer.MAX_VALUE){
            return dp[n][v];//캐시
        }
        //다음으로 갈 도시 체크
        for (int i = 0; i < N; i++) {
            if((v & (1 << i)) == 0 && arr[n][i] != 0){
                //아직 가지 않았고 길이 있을때
                //최종 답은 = min(원래 값, 도시를 전부 방문한 값)
                dp[n][v] = Math.min(dp[n][v], tsp(i,(v | (1<<i))) + arr[n][i]);
            }
        }
        return dp[n][v];
    }
    static void print(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if(arr[i][j]==Integer.MAX_VALUE) System.out.print("N ");
                else System.out.print(arr[i][j] +" ");
            }
            System.out.println();
        }
    }
    static void init(){
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
    }
}
