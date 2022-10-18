package graph.floydwarshall;

class SearchPath {
//    static int N = 3;
//    static int[][] arr = {
//            {0,1,0},
//            {0,0,1},
//            {1,0,0}
//    };
    static int N = 7;
    static int[][] arr ={
            {0,0,0,1,0,0,0},
            {0,0,0,0,0,0,1},
            {0,0,0,0,0,0,0},
            {0,0,0,0,1,1,0},
            {1,0,0,0,0,0,0},
            {0,0,0,0,0,0,1},
            {0,0,1,0,0,0,0}
    };
    static int[][] answer = new int[N][N];
//    static {
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                if(i==j) answer[i][j]=1;
//            }
//        }
//    }

    public static void main(String[] args) {
        solve();
        print();
    }
    static void solve(){

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if((arr[i][k]==1 && arr[k][j]==1)|| arr[i][j]==1) {
                        answer[i][j]=1;
                        answer[j][i]=1;
                    }
                }

            }
        }
    }
    private static void print() {
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[0].length; j++) {
                System.out.print(answer[i][j] +" ");
            }
            System.out.println();
        }
    }
}
