package datastructure.stackandqueue;

class Okunsu {
    static int[] arr = {3,5,2,7};

    public static void main(String[] args) {
        find(4);
    }
    static void find(int n){
        int me = arr[n - 1];
        int i;
        for (i = n; i < arr.length; i++) {
            if(me<arr[i]) {
                System.out.println(arr[i]);
                break;
            }
        }
        if(i==arr.length) System.out.print("-1");
    }
}
