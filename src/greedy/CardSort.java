package greedy;

class CardSort {
    static int[] cards = {10,20,40};
    static int N = cards.length;
    static boolean[] selected = new boolean[N];
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        count(0, 0);
        System.out.println("min="+min);
    }
    static int count(int count, int n){
        if(n==N) return count;
        for (int i = 0; i < N; i++) {
            if(! selected[i]){
                selected[i] = true;
                System.out.println("count = "+ count);
                min = Math.min(min,count(cards[i] + count, n+1));
                selected[i] = false;
            }
        }
        return min;
    }
}
