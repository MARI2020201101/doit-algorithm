package graph.floydwarshall;

class SearchPath2 {

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

    public static void main(String[] args) {
        solve();
        print();
    }
    static void solve(){

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if((arr[i][k]==1 && arr[k][j]==1)|| arr[i][j]==1) {
                        answer[i][j]=1;

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
