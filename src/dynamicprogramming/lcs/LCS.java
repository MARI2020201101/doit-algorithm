package dynamicprogramming.lcs;

class LCS {
    public static void main(String[] args) {
        System.out.println(lcs("ACAYKP","CAPCAK"));
    }
    static String lcs(String a, String b){
        int pa = 0;
        int pb = 0;

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        while(pa != a.length() && pb != b.length()){
            if(a.charAt(pa) == b.charAt(pb)){
                sb1.append(a.charAt(pa));
                pa++;
                pb++;
            }else{
                pb++;
            }
        }
        System.out.println(sb1.toString());
        pa = 0; pb = 0;
        while(pa != a.length() && pb != b.length()){
            if(a.charAt(pa) == b.charAt(pb)){
                sb2.append(b.charAt(pb));
                pa++;
                pb++;
            }else{
                pa++;
            }
        }
        System.out.println(sb2.toString());
        return "";
    }
}
