package combination.pebbles;

class Pebbles2 {
    static int M = 3;
    static int total = 18;
    static double[] pebbles = {5,6,7};
    static int K= 2;

    public static void main(String[] args) {
        System.out.println(calculate());
    }
    static double calculate(){
        double result = 0;
        double totalPebbles = total;
        for (int i = 0; i < pebbles.length; i++) {
            double pebble = pebbles[i];
            double tmp = 1;
            for (int j = K; j > 0 ; j--) {
                tmp*=pebble/totalPebbles;
                pebble--;
                totalPebbles--;
            }
            result += tmp;
        }
        return result;
    }
}
