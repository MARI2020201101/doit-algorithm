package dp.eggdrop;

class EggDrop {
    public static void main(String[] args) {
        System.out.println(eggDrop(100,2));
    }
    static int eggDrop(int n, int x){
        if(n==0 || n==1 || x==1){
            return n;
        }
        int result1 = 0;
        int result2 = 0;
        for (int p = 1; p <= n; p++) {
            result1 = eggDrop(p-1, x-1);
            result2 = eggDrop(n-p, x);

        }
        return Math.max(result1, result2);
    }
}
