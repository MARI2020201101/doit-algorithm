package graph;

class Water {
    static int N = 3;
    static int[] bucket = {8,9,10};
    static int[] water = {0,0,10};

    public static void main(String[] args) {
        water();
    }
    static void water(){
        move(0, 1 ,2);
        move(1, 0, 2);
    }

    private static void move(int a, int b, int c) {

        while(water[b]<bucket[b] || water[c]>0){
            water[b]++;
            water[c]--;
        }

        if(water[0]==0){
            System.out.print(water[2] +" ");
            return;
        }
        move(c, a, b);
        move(b, a, c);


    }
}
