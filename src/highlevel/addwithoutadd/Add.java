package highlevel.addwithoutadd;

class Add {
    public static void main(String[] args) {
        System.out.println(add(1999,19));
    }
    static int add(int a, int b){
        while(b!=0){
            int num = a^b;
            int carry = (a&b)<<1;
            a = num;
            b = carry;
            System.out.println(String.format("num=%d, carry=%d",num,carry));
        }
        return a;
    }
}
