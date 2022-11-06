package dynamicprogramming.lcs;

class LCS2 {
    public static void main(String[] args) {
        System.out.println(lcs("ACAYKP","CAPCAK"));
    }
    static String lcs(String a, String b){
        StringBuilder sb = new StringBuilder();
        if(a.length() == 0 || b.length() == 0){
            sb.append("");
            return sb.toString();
        }
        String first = a.substring(0,1);
        String remain1 = a.substring(1);
        String second = b.substring(0,1);
        String remain2 = b.substring(1);
        String lcs = "";
        String lcs1 = "";
        String lcs2 = "";
        if(first.equals(second)){
            sb.append(first);
            lcs = lcs(remain1, remain2);
        }else{
            lcs1 = lcs(remain1 , b);
            lcs2 = lcs(a, remain2);
        }

        String longest = lcs.length() >  lcs1.length() ? lcs : lcs1;
        String longest2 = lcs1.length() >  lcs2.length() ? lcs1 : lcs2;
        String longest3 = longest.length() >  longest2.length() ? longest : longest2;
        sb.append(longest3);
        return sb.toString();
    }
}
