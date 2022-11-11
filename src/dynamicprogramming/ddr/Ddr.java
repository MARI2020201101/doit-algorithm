package dynamicprogramming.ddr;

class Ddr {
    static int[] target = {1,2,2,4};
    static int N = 4;

    public static void main(String[] args) {
        ddr();
    }
    static void ddr(){
        int[][][] arr = new int[target.length][N+1][N+1];
        int left = 0;
        int right = 0;
        arr[0][0][1] = 2;
        arr[0][1][0] = 2;
        int total = 2;
        for (int i = 1; i < target.length; i++) {
            int valL = calculateValue(left, target[i]);
            int valR = calculateValue(right, target[i]);
            if(valL == valR){
                arr[i][target[i]][right] = arr[i-1][target[i]][right] + valL;
                arr[i][left][target[i]] = arr[i-1][left][target[i]] + valR;
                total+=valL;
            }else if(valL < valR){
                arr[i][target[i]][right] = arr[i-1][target[i]][right] +valL;
                total+=valL;
            }else{
                arr[i][left][target[i]] = arr[i-1][left][target[i]] + valR;
                total+=valR;
            }
        }
        print(arr);
        System.out.println("total ="+ total);
    }
    static void print(int[][][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                for (int k = 0; k < arr[0][0].length; k++) {
                    System.out.print(arr[i][j][k] +" ");
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
