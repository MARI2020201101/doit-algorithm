package dynamicprogramming.pinarynumber;

class PinaryNumber {
    static int N = 6;

    public static void main(String[] args) {
        printPinaryNumber(1, "1");
    }
    static void printPinaryNumber(int n, String str){
        if(n==N){
            System.out.println(str);
            return;
        }
        String last = str.substring(str.length() - 1);
        if(last.equals("0")){
            String next0 = str+"0";
            String next1 = str+"1";
            printPinaryNumber(n+1, next0);
            printPinaryNumber(n+1, next1);
        }else{
            String next0 = str+"0";
            printPinaryNumber(n+1, next0);
        }
    }
}
