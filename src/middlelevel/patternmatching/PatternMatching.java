package middlelevel.patternmatching;

class PatternMatching {
    static String value = "catcatgocatgo";
    static String pattern ="aabab";

    public static void main(String[] args) {
        System.out.println(doesMatch(pattern,value));
    }
    static boolean doesMatch(String pattern, String value){
        for (int i = 0; i < value.length(); i++) {
            String mainStr = value.substring(0, i+1);
            for (int j = i; j < value.length(); j++) {
                for (int k = j; k < value.length(); k++) {
                    String altStr = value.substring(j,k+1);
                    System.out.println("mainStr : "+mainStr);
                    System.out.println("altStr : "+altStr);
                    String candidate = buildPattern(pattern, mainStr, altStr);
                    System.out.println(candidate);
                    if(candidate.equals(value)) return true;
                }
            }
        }
        return false;
    }

    private static String buildPattern(String pattern, String mainStr, String altStr) {
        char c = pattern.charAt(0);
        StringBuilder sb = new StringBuilder();
        sb.append(mainStr);
        for (int i = 1; i < pattern.length(); i++) {
            sb.append(pattern.charAt(i) == c ? mainStr : altStr);
        }
        return sb.toString();
    }
}
