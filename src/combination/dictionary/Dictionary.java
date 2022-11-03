package combination.dictionary;

class Dictionary {

    static int N = 3; //a
    static int M = 3; //z
    static int K = 9;
    static int combination[][] = new int[N+M][N+M];

    public static void main(String[] args) {
        initCombination();
        solve(N-1,M,K, "");
    }
    static void solve(int n, int m, int k, String str){
        if(m == 0 || n == 0) {

            if(m>0){
                for (int i = 0; i < m; i++) {
                    str+="z";
                }
            }
            System.out.println(str);
            return;
        }
        if(k < combination[n+m][m]){
            str +="a";
            solve(n-1,m,k, str);
        }else{
            str += "z";
            solve(n-1,m-1, k - combination[n+m][m], str);
        }
    }

    static void initCombination(){
        for (int i = 0; i < combination.length; i++) {
            combination[i][0] = 1;
            combination[0][i] = 1;
            combination[i][i] = 1;
        }
        for (int i = 1; i < combination.length; i++) {
            for (int j = 1; j < combination[0].length && j < i; j++) {
                 combination[i][j] = combination[i-1][j] + combination[i][j-1];
            }
        }
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
