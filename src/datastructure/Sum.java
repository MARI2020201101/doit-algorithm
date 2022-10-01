package datastructure;

class Sum {
    public static void main(String[] args) {
        System.out.println(sum( "12345"));
    }
    static int sum(String str){
        return str.chars()
                .map(c-> c-'0')
                .sum();
    }

}
