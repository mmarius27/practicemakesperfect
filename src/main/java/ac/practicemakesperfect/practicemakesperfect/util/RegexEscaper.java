package ac.practicemakesperfect.practicemakesperfect.util;

public class RegexEscaper {
    
    static public String escapeSpecialCaracters(String s){
        String strPattern = "\\[~!@#$%^&*()_+{}:;,.<>/?-]";

        for (char c : strPattern.toCharArray()) {
            String sc = "" + c;
            String scr = "\\" + c;
            s = s.replace(sc, scr);
        }

        return s;
    }
}
