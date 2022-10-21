package coding.permutation;

class Permutation {
    static String str = "ABCDE";

    public static void main(String[] args) {
        permutation(str,"");
    }
    static void permutation(String str, String pre){
        if(str.length() == 0){
            System.out.println(pre);
            return;
        }
        for(int i = 0; i < str.length() ; i++){
            String next = str.substring(0,i) + str.substring(i+1);
            permutation(next, pre + str.charAt(i));
        }
    }
}
