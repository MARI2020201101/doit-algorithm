package bitoperation.printbinary;

class PrintBinary {
    public static void main(String[] args) {
        System.out.println(printBinary(0.72));
        System.out.println(printBinary2(0.72));
        System.out.println(printBinary(0.875));
    }
    static String printBinary(double num){
        StringBuilder sb = new StringBuilder();
        sb.append("0.");
        while(num > 0){
            num *=2;
            if(num >= 1){
                sb.append("1");
                num--;
            }else{
                sb.append("0");
            }
        }
        return sb.toString();
    }
    static String printBinary2(double num){
        StringBuilder sb = new StringBuilder();
        sb.append("0.");
        double frac = 0.5;
        while(num > 0){
            if(num >= frac){
                sb.append("1");
                num-=frac;
            }else{
                sb.append("0");
            }
            frac/=2;
        }
        return sb.toString();
    }
}
