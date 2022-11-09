package dynamicprogramming.tile;

class Tile {
    static int N = 9;

    public static void main(String[] args) {

    }
    static int tile(int n){
        if(n <= 0) return 1;
        return tile(n-1) + tile(n-2);
    }
}
