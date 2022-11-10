package dynamicprogramming.maxsquare;

class MaxSquare {
    static int[][] arr = {
            {0,1,0,0},
            {0,1,1,1},
            {1,1,1,0},
            {0,0,1,0},
    };

    public static void main(String[] args) {
        System.out.println(maxSquare());
        print(arr);
    }
    static int maxSquare(){
        int maxSquare = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                int min = Math.min(Math.min( Math.min(arr[i-1][j-1], arr[i-1][j]) , arr[i][j-1]) , arr[i][j]);
                arr[i][j] = min+1;
                maxSquare = Math.max(maxSquare, arr[i][j]);
            }
        }
        return maxSquare;
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
