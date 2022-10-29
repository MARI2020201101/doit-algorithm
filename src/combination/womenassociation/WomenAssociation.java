package combination.womenassociation;

class WomenAssociation {
    static int N = 10;
    static int[][] arr = new int[N][N];

    public static void main(String[] args) {
        init();
        print(arr);
        System.out.println(womenAssociation(1,3));
        System.out.println(womenAssociation(2,3));
    }
    static int womenAssociation(int i, int j){
        return arr[i][j];
    }
    static void init(){
        for (int i = 0; i < N; i++) {
            arr[0][i]=i;
        }
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N; j++) {
                arr[i][j] = arr[i-1][j] + arr[i][j-1];
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
