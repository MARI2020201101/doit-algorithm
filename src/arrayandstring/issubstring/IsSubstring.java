package arrayandstring.issubstring;

class IsSubstring {
    public static void main(String[] args) {
        System.out.println(isRotation("watermelon", "ermelonwat"));
        System.out.println(isRotation("watermelon", "armelonwat"));
    }
    static boolean isRotation(String str, String sub){
        String strstr = str + str;
        return isSubstring(strstr, sub);
    }

    private static boolean isSubstring(String strstr, String sub) {
        return strstr.contains(sub);
    }
}
