package highlevel.histogram;

class Histogram {
    static int[] histogram = {0,0,4,0,0,6,0,0,3,0,5,0,1,0,0,0};

    public static void main(String[] args) {
        BarGraph[] bars = initMax(histogram);
        for (BarGraph bar : bars) {
            System.out.println(bar);
        }
        System.out.println(compute(bars));
    }
    static int compute(BarGraph[] bars){
        int sum=0;
        int i;
        for (i = 0; i < bars.length && bars[i].leftMax!=bars[i].rightMax; i++) {
            int water = Math.min(bars[i].leftMax, bars[i].rightMax);
            System.out.println(String.format("[%d] sum=%d", i,water * (water-bars[i].height)));
            sum += water * (water-bars[i].height);
        }

        for (int j = bars.length-1; j > i; j--) {
            int water = Math.min(bars[i].leftMax, bars[i].rightMax);
            System.out.println(String.format("[%d] sum=%d", j,water * (water-bars[j].height)));
            sum += water * (water-bars[i].height);
        }
        return sum;
    }
    static BarGraph[] initMax(int[] histogram){
        BarGraph[] bars = new BarGraph[histogram.length];
        for (int i = 0; i < bars.length; i++) {
            bars[i] = new BarGraph();
            bars[i].height = histogram[i];
        }
        int lMax=0;
        for (int i = 0; i < histogram.length; i++) {
            lMax = Math.max(lMax, bars[i].height);
            bars[i].leftMax = lMax;
        }
        int rMax = 0;
        for (int i = histogram.length-1; i >= 0 ; i--) {
            rMax = Math.max(rMax, bars[i].height);
            bars[i].rightMax = rMax;
        }
        return bars;
    }

}
class BarGraph{
    int leftMax;
    int rightMax;
    int height;

    @Override
    public String toString() {
        return "BarGraph{" +
                "leftMax=" + leftMax +
                ", rightMax=" + rightMax +
                ", height=" + height +
                '}';
    }

}