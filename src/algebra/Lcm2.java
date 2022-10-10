package algebra;

class Lcm2 {
    public static void main(String[] args) {
        System.out.println(lcm(1,45000));
        System.out.println(lcm(6,10));
        System.out.println(lcm(13,17));
    }


    static int lcm(int n, int m){
        return n*m/gcd(n,m);
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
