package sort.selection;

class SelectionSort2 {
    static String str = "2143";
    public static void main(String[] args) {
        sort();
    }
    static void sort(){
        for (int i = 0; i < str.length(); i++) {
            int min = i;
            for (int j = i; j < str.length(); j++) {
                if(str.charAt(j) < str.charAt(min)) min=j;
            }
            str=swap(str, i , min);
        }
        System.out.println(str);
    }
    private static String swap(String str, int a, int b) {
        StringBuilder sb = new StringBuilder(str);
        char c = str.charAt(a);
        sb.setCharAt(a, str.charAt(b));
        sb.setCharAt(b, c);
        return sb.toString();
    }
}
