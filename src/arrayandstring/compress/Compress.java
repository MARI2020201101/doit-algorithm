package arrayandstring.compress;

class Compress {
    public static void main(String[] args) {
        System.out.println(compress("aabccccaaa"));
    }
    static String compress(String str){
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 1; i < str.length(); i++) {
            count++;
            if(i == str.length()-1 ||str.charAt(i-1)!=str.charAt(i)){
                sb.append(str.charAt(i-1));
                sb.append(count);
                count = 0;
            }
        }
        return sb.toString();
    }
}
