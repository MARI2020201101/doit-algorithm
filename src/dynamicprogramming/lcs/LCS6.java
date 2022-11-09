package dynamicprogramming.lcs;

public class LCS6 {
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
        StringBuilder sb = new StringBuilder();
        while(pa!=0 && pb!=0){
            if(a.charAt(pa) == b.charAt(pb)){
                --pa;
                --pb;
                sb.append(a.charAt(pa));
            }else{
                if(arr[pa-1][pb] > arr[pa][pb-1]){
                    --pa;
                }else{
                    --pb;
                }
            }
        }
        return sb.reverse().toString();
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
