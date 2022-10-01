package datastructure;

class Sum2 {
    public static void main(String[] args) {
        System.out.println(sum( "12345"));
    }
    static int sum(String str){
        char[] chars = str.toCharArray();
        int sum = 0;
        for(char c : chars){
            sum+=c-'0';
        }
        return sum;
    }

}
