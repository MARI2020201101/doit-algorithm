package dynamicprogramming.travelingsalesman;

public class TSP2 {
    static int N = 4;
    static int[][] arr = {
            {0,10,15,20},
            {5,0,9,10},
            {6,13,0,12},
            {8,8,9,0},
    };
    static int[][] answer = new int[N][N];

    public static void main(String[] args) {
        init();
        calculate();
        print(answer);
    }
    static void init(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                answer[i][j] = Integer.MAX_VALUE;
            }
        }
    }
    static void calculate(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    System.out.println(String.format("i=%d, j=%d, k=%d",i,j,k));
                    answer[i][j] = Math.min(answer[i][j], arr[i][k] + arr[k][j]);
                }
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
