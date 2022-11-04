package dynamicprogramming.countstairs;

class CountStairs {
    static int N = 2;
    static int[][] answer = new int[N][10];
    static int stairs = 0;

    public static void main(String[] args) {
        solve();
        print(answer);
        System.out.println("stairs count = "+ stairs);
    }
    static void solve(){
        for (int i = 1; i < answer[0].length; i++) {
            answer[0][i] = 1;
        }
        for (int i = 1; i < answer.length; i++) {
            for (int j = 0; j < answer[0].length; j++) {
                if(j-1 >= 0) answer[i][j] += answer[i-1][j-1];
                if(j+1 < answer[0].length) answer[i][j] += answer[i-1][j+1];
            }
        }

        for (int i = 0; i < answer[0].length; i++) {
            stairs+=answer[N-1][i];
        }
    }
    static void print(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] +" ");
            }
            System.out.println();
        }
    }
}
