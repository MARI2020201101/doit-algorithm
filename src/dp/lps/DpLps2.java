package dp.lps;

import com.sun.security.jgss.GSSUtil;

class DpLps2 {
    public static void main(String[] args) {
        System.out.println(lps("BBABCBCAB"));
    }
    static int lps(String str){
        int[][] arr = new int[str.length()][str.length()];
        for (int i = 0; i < arr.length; i++) {
            arr[i][i] = 1;
        }
        int n = str.length();
        for(int k=2; k<=n; k++){
            for(int i=0; i < n-k+1; i++){
                int j = i+k-1;
                System.out.println(String.format("k=%d, i=%d, j=%d",k,i,j));
                if(str.charAt(i)==str.charAt(j) && k==2) arr[i][j]=2;
                else if(str.charAt(i)==str.charAt(j))arr[i][j]=arr[i+1][j-1]+2;
                else arr[i][j] = Math.max(arr[i+1][j], arr[i][j-1]);
            }
            System.out.println("--------------");
        }
        return arr[0][str.length()-1];
    }
}
