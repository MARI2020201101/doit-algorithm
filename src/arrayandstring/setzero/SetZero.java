package arrayandstring.setzero;

class SetZero {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3,4,0},
                {6,7,8,9,5},
                {1,0,2,3,4},
                {6,7,8,9,5},
                {1,2,3,4,5},
        };
        setZero(matrix);
        print(matrix);
    }
    static void setZero(int[][] matrix){
        boolean zeroRow = false;
        boolean zeroCol = false;
        for (int i = 0; i < matrix.length; i++) {
            if(matrix[i][0]==0) {
                zeroRow = true;
                break;
            }
        }
        for (int j = 0; j < matrix[0].length; j++) {
            if(matrix[0][j]==0) {
                zeroCol = true;
                break;
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][j]==0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            if(matrix[i][0] == 0){
                nullifyRow(matrix , i);
            }
        }
        for(int j =0 ; j<matrix[0].length ; j++){
            if(matrix[0][j]==0){
                nullifyCol(matrix, j);
            }
        }
        if(zeroRow){
            nullifyCol(matrix,0);
        }
        if(zeroCol){
            nullifyRow(matrix, 0);
        }
    }

    private static void nullifyCol(int[][] matrix, int j) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][j] = 0;
        }
    }

    private static void nullifyRow(int[][] matrix, int i) {
        for (int j = 0; j < matrix[0].length; j++) {
            matrix[i][j] = 0;
        }
    }

    static void print(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
