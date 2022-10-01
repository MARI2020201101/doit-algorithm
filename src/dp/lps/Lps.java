package dp.lps;

class Lps {
    public static void main(String[] args) {
        System.out.println(lps("BBABCBCAB",0, "BBABCBCAB".length()-1));
    }
    static int lps(String a, int start, int end){
        if(start>end) return 0;
        if(start==end) return 1;
        if(a.charAt(start) == a.charAt(end)){
            return lps(a, start+1, end-1) +2;
        }else{
            return Math.max(lps(a, start+1, end), lps(a, start, end-1));
        }
    }
}
