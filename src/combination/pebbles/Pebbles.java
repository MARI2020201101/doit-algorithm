package combination.pebbles;

class Pebbles {
    static int N = 18;
    static int R = 2;
    static int[][] arr = new int[N+1][N+1];

    public static void main(String[] args) {
        init();
        System.out.println(calculate());
    }
    static double calculate(){
        double result = 0;
        result+=nCr(5,2)+nCr(6,2)+nCr(7,2);
        result/=nCr(18,2);
        return result;
    }
    static int nCr(int n, int r){
        return arr[n][r];
    }
    static void init(){
        for (int i = 0; i <= N; i++) {
            arr[i][0] = 1;
            arr[0][i] = 1;
        }
        for (int i = 0; i <= N; i++) {
            arr[i][i] = 1;
        }
        for (int i = 1; i <= N; i++) {
            for (int j = i-1; j > 0; j--) {
                arr[i][j] = arr[i-1][j] + arr[i-1][j-1];
            }
        }
    }
}
