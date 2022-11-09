package dynamicprogramming.lcs;

public class LCS8 {
    public static void main(String[] args) {
        System.out.println(lcs("ACAYKP","CAPCAK"));

    }
    static String lcs(String a, String b){
        int aLen = a.length();
        int bLen = b.length();
        int[][] arr = new int[aLen+1][bLen+1];

        for (int i = 0; i < aLen; i++) {
            arr[i][0] = a.charAt(i)==b.charAt(0)?1:0;
        }
        for (int i = 0; i < bLen; i++) {
            arr[0][i] = a.charAt(0)==b.charAt(i)?1:0;
        }

        for (int i = 1; i < aLen; i++) {
            for (int j = 1; j < bLen; j++) {
                if(a.charAt(i) == b.charAt(j)){
                    arr[i][j] = Math.max(arr[i-1][j], arr[i][j-1]) + 1;
                }else{
                    arr[i][j] = Math.max(arr[i-1][j], arr[i][j-1]);
                }
            }
        }
        print(arr);
        int pa = aLen-1;
        int pb = bLen-1;
        printLCS(pa,pb,a,b,arr,"");
        return "";
    }
    static String printLCS(int pa, int pb, String a, String b, int[][] arr, String str){
        if(pa == 0 || pb == 0){
            System.out.println(str);
            return str;
        }
        if(arr[pa][pb] == arr[pa-1][pb]){
            printLCS(--pa, pb, a, b, arr, str);
        }else if(arr[pa][pb] == arr[pa][pb-1]){
            printLCS(pa, --pb, a, b, arr, str);
        }else{
            str+=a.charAt(pa);
            printLCS(--pa, --pb, a, b, arr, str);
        }


        return str;
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
