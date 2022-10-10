package algebra;

class Lcm {
    public static void main(String[] args) {
        System.out.println(gcd(12,10));
        System.out.println(gcd(40,8));
    }



    static int gcd(int n, int m){
        while(m!=0 && n!=0) {
            if(n < m){
                int swap = m;
                m = n;
                n = swap;
            }
            int tmp = m;
            m = n%m;
            n = tmp;
        }
        return Math.max(n,m);
    }
}
