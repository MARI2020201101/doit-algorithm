package coding.mathmatics;

class CountSubStr {

    public static void main(String[] args) {
        System.out.println(count("1111111","11"));
    }
    static int count(String str,String text){
        int point = 0;
        int count = 0;
        int len = text.length();
        while(str.indexOf(text, point)!=-1){
            count++;
            point+=len;
        }
        return count;
    }
}
