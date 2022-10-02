package dp.lps;

class DpLps {
    public static void main(String[] args) {
        System.out.println(lps("BBABCBCAB"));
    }
    static int lps(String a){
        int[][] arr = new int[a.length()][a.length()];
        for (int i = 0; i < arr.length; i++) {
            arr[i][i] = 1;
        }

        for (int i = 2; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(j-i-1==2 && a.charAt(i)==a.charAt(j)) arr[i][j]=2;
                else if(a.charAt(i)==a.charAt(j)) arr[i][j] = arr[i+1][j-1] + 2;
                else arr[i][j] = Math.max(arr[i+1][j] , arr[i][j-1]);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] +" ");
            }
            System.out.println();
        }
        return arr[0][a.length()-1];
    }
}
