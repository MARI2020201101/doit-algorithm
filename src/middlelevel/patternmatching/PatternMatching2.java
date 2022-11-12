package middlelevel.patternmatching;

class PatternMatching2 {
    static String value = "catcatgocatgo";
    static String pattern ="aabab";

    public static void main(String[] args) {
        System.out.println(doesMatch(pattern,value));
    }
    static boolean doesMatch(String pattern, String value){
        int mainSize = getCount(pattern, pattern.charAt(0));
        int altSize = pattern.length() - mainSize;
        int maxMainSize = value.length() / mainSize;
        for (int i = 0; i <= maxMainSize; i++) {
            String mainStr = value.substring(0, i+1);
            int maxAltSize = value.length() - i*mainSize ;
            for (int j = i+1; j <= maxAltSize; j++) {
                for (int k = j; k <= maxAltSize; k++) {
                    String altStr = k+1 > value.length() ? value.substring(j) : value.substring(j, k+1);
                    System.out.println(String.format("mainStr=%s, altStr=%s",mainStr, altStr));
                    String candidate = buildPattern(pattern, mainStr, altStr);
                    System.out.println("candidate : "+candidate);
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
    private static int getCount(String pattern, char c) {
        int count = 0;
        for (int i = 0; i < pattern.length(); i++) {
            if(pattern.charAt(i) == c) count++;
        }
        return count;
    }


}
