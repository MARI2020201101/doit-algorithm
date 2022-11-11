package dynamicprogramming.knapsack;

class Knapsack {
    static int N = 4;
    static int MAX_SIZE = 7;
    static Stuff[] stuffs = {
            new Stuff(6,13),
            new Stuff(4,8),
            new Stuff(3,6),
            new Stuff(5,12),
    };

    public static void main(String[] args) {
        knapsack();
    }
    static void knapsack(){
        int[][] arr = new int[N][MAX_SIZE+1];
        arr[0][stuffs[0].kg] = stuffs[0].value;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if(arr[i-1][j] != 0 && j + stuffs[i].kg <= MAX_SIZE){
                    arr[i][j+stuffs[i].kg] = arr[i-1][j] + stuffs[i].value;
                }if(arr[i-1][j] != 0){
                    arr[i][j] = arr[i-1][j];
                }else if(stuffs[i].kg <= MAX_SIZE){
                    arr[i][stuffs[i].kg] = stuffs[i].value;
                }
            }
        }
        print(arr);
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
class Stuff {
    int kg;
    int value;

    public Stuff(int kg, int value) {
        this.kg = kg;
        this.value = value;
    }
}