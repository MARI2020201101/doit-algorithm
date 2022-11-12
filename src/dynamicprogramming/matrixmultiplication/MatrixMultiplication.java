package dynamicprogramming.matrixmultiplication;

class MatrixMultiplication {
    static int N = 3;
    static int minMultiply = Integer.MAX_VALUE;
    static Matrix[] matrices = {
            new Matrix(5,3),
            new Matrix(3,2),
            new Matrix(2,6),
    };

    public static void main(String[] args) {
        System.out.println(calculate(0,N-1));
    }
    static int calculate(int i, int j){
        if(i==j) return 0;
        else if(Math.abs(i-j)==1){
            return matrices[i].row * matrices[i].col * matrices[j].col;
        }else{
            for (int k = i+1; k < j; k++) {
                minMultiply = Math.min(minMultiply,  matrices[i].row * matrices[k].col * matrices[j].col + calculate(i,k) + calculate(k+1,j));
            }
            return minMultiply;
        }
    }
}
class Matrix{
    int row;
    int col;

    public Matrix(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
