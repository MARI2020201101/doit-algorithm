package datastructure.twopointer;

class TwoPointer2 {
    public static void main(String[] args) {
        System.out.println(count(15));
    }
    static int count(int n){
        int cnt = 1;
        int[][] arr = new int[n / 2 + 2][n / 2 + 2];
        for (int i = 0; i < arr.length; i++) {
            arr[i][i] = i;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i+1; j < arr[0].length; j++) {
                arr[i][j] = arr[i][j-1] + j;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if(arr[i][j] == n) cnt++;
            }
        }
        return cnt;
    }
}
