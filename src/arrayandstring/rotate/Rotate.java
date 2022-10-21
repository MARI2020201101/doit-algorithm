package arrayandstring.rotate;

class Rotate {
    public static void main(String[] args) {
        int[][] matrix = {
                {11,12,13,14,15},
                {16,17,18,19,20},
                {21,22,23,24,25},
                {26,27,28,29,30},
                {31,32,33,34,35},
        };
        rotate(matrix);
        print(matrix);
    }
    static void rotate(int[][] matrix){
        int n = matrix.length;
        for(int layer = 0; layer < n/2 ; layer++){
            int first = layer;
            int last = n - 1 - layer;
            for(int i = first; i < last ; i++){
                int offset = i - first;
                int tmp = matrix[first][i];

                matrix[first][i] = matrix[last-offset][first];
                System.out.println(String.format("matrix[%d][%d] = matrix[%d][%d]",first,i,last-offset,first));
                matrix[last-offset][first] = matrix[last][last-offset];
                matrix[last][last-offset] = matrix[i][last];
                matrix[i][last] = tmp;
            }
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
