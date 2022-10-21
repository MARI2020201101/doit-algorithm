package arrayandstring.oneedit;

class OneEdit {
    public static void main(String[] args) {
        System.out.println(oneEdit("pale","bale"));
        System.out.println(oneEdit("pale","ple"));
        System.out.println(oneEdit("pales","pale"));
        System.out.println(oneEdit("pale","bake"));
    }
    static boolean oneEdit(String a, String b){
        if(Math.abs(a.length() - b.length()) > 1 ) return false;
        String first = a.length() <= b.length() ? a : b;
        String second = a.length() > b.length() ? a : b;

        int idx1 = 0;
        int idx2 = 0;
        boolean canOneEdit = true;
        while(idx1 < first.length() && idx2 < second.length()){
            if(first.charAt(idx1) != second.charAt(idx2)){
                if(! canOneEdit){
                    return false;
                }
                canOneEdit = false;
                if(first.length() ==  second.length()) {
                    idx1++;
                }
            }else{
                idx1++;
            }
            idx2++;
        }
        return true;
    }
}
