package combination.pebbles;

import java.util.Arrays;

class Pebbles3 {
    static int M = 3;
    static int total = 18;
    static double[] pebbles = {5,6,7};
    static double[] probability = new double[pebbles.length];
    static int K= 2;

    public static void main(String[] args) {
        System.out.println(calculate());
        System.out.println(Arrays.toString(probability));
    }
    static double calculate(){
        double probabilities = 0;
        for (int i = 0; i < pebbles.length; i++) {
            probability[i] = 1.0;
            for (int k = 0; k < K; k++) {
                probability[i] *= (pebbles[i] - k)/(total - k);
            }
            probabilities += probability[i];
        }
        return probabilities;
    }
}
