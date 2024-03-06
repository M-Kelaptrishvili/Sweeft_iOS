import java.util.HashMap;

public class ex1 {

    public static int lengthOfLongestSubstring(String s) {

        if(s.length()==1) return 1;
        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if(i > j) continue;
                String substring = s.substring(i, j+1);
                if(substring.length() <= length) continue;
                boolean repeated =  false;
                for (int k = 0; k < substring.length(); k++) {
                    if(substring.indexOf(substring.charAt(k)) != substring.lastIndexOf(substring.charAt(k))) {
                        repeated = true;
                        break;
                    }
                }
                if(!repeated && length < substring.length()) length = substring.length();
            }
        }
        return length;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}