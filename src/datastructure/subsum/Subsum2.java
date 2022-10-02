package datastructure.subsum;

class Subsum2 {
    public static void main(String[] args) {
        System.out.println(subsum());
    }
    static int[][] arr = {
            {1,2,3,4},
            {2,3,4,5},
            {3,4,5,6},
            {4,5,6,7}
    };
    static int subsum() {
        int[][] sums = new int[arr.length+1][arr[0].length+1];
        for (int i = 0; i < sums.length; i++) {
            sums[i][0]=0;
        }
        for (int i = 0; i < sums[0].length; i++) {
            sums[0][i]=0;
        }
        for (int i = 1; i < sums.length; i++) {
            for (int j = 1; j < sums[0].length; j++) {
                if(j-1 == 0) sums[i][j] = arr[i-1][j-1]+sums[i-1][sums[0].length-1];
                else sums[i][j] = arr[i-1][j-1]+sums[i][j-1];
            }
        }
        print(sums);
        return sums[3][4]-sums[2][2];

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
