package dynamicprogramming.ddr;

class Ddr3 {
    static int[] target = {1,2,2,4};
    static int N = 4;
    static int INF = 999;

    public static void main(String[] args) {
        ddr();
    }
    static void ddr(){
        int[][][] arr = new int[target.length][N+1][N+1];
        for (int i = 0; i < target.length; i++) {
            for (int j = 0; j <= N; j++) {
                for (int k = 0; k <= N; k++) {
                    arr[i][j][k] = INF;
                }
            }
        }
        for (int i = 0; i <=N; i++) {
            arr[0][0][i] = calculateValue(0,i);
            arr[0][i][0] = calculateValue(0,i);
        }
        for (int i = 1; i < target.length; i++) {
            for (int j = 0; j <= N; j++) {
                for (int k = 0; k <= N; k++) {
                    if(j == target[i]) continue;
                    arr[i][target[i]][k] = Math.min(arr[i][target[i]][k], arr[i-1][j][k] + calculateValue(j,target[i]));
                }
            }
        }
        for (int i = 1; i < target.length; i++) {
            for (int k = 0; k <= N; k++) {
                for (int j = 0; j <= N; j++) {
                    if(k == target[i]) continue;
                    arr[i][j][target[i]] = Math.min(arr[i][j][target[i]], arr[i-1][j][k] + calculateValue(k,target[i]));
                }
            }
        }
        print(arr);

    }
    static void print(int[][][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                for (int k = 0; k < arr[0][0].length; k++) {
                    if(arr[i][j][k] == INF) System.out.print("N ");
                    else System.out.print(arr[i][j][k] +" ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    static int calculateValue(int from, int to){
        if(from == 0) return 2;
        else if(from == to) return 1;
        else if(Math.abs(from-to)==1) return 3;
        else return 4;
    }
}
