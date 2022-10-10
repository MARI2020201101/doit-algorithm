package algebra;

class PowNum {
    public static void main(String[] args) {
        System.out.println(count(1, 10));
    }
    public static int count(int min, int max){
        int count = max - min + 1;
        int sqrt =(int) Math.sqrt(max);
        return count - sqrt;
    }
}
