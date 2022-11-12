package dynamicprogramming.ddr;

class Ddr4 {
    static int[] target = {1,2,2,4};
    static int N = 4;
    static int INF = 999;
    static int minVal = INF;

    public static void main(String[] args) {
        ddr(0,0,0,0);
        System.out.println("minVal = "+minVal);
    }
    static void ddr(int n, int left, int right, int value){
        if(n == N) {
            minVal = Math.min(minVal, value);
            return;
        }
        int to = target[n];
        int leftVal = calculateValue(left, to);
        int rightVal = calculateValue(right, to);
        System.out.println(String.format("[%d] left=%d, right=%d, leftVal=%d, rightVal=%d",n,left, right ,leftVal,rightVal));
        if(leftVal == rightVal){
            ddr(n+1, to, right,value + leftVal);
            ddr(n+1, left, to,value + rightVal);
        }else if(leftVal < rightVal){
            ddr(n+1, to, right,value + leftVal);
        }else{
            ddr(n+1,left, to,value + rightVal);
        }

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
        else if(Math.abs(from-to)==1 || Math.abs(from-to)==3) return 3;
        else return 4;
    }
}
