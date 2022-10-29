package combination.binomialcoefficient;

class NCR {
    static int N = 5;
    static int R = 2;
    static int[][] arr = new int[N+1][N+1];

    public static void main(String[] args) {
        init();
        print(arr);
        System.out.println(nCr(N,R));
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
    static void print(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] +" ");
            }
            System.out.println();
        }
    }
}
