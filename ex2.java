import java.util.HashMap;

public class ex2 {
    public static String minWindow(String s, String t) {
        String result = "";
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.put(Character.valueOf(t.charAt(i)), map.getOrDefault(Character.valueOf(t.charAt(i)), 0)+1);
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if(i > j) continue;
                String substring = s.substring(i, j+1);
                if(result.length() != 0 && substring.length() >= result.length()) continue;
                boolean fit = true;
                HashMap<Character, Integer> currMap = new HashMap<>();
                for (int k = 0; k < substring.length(); k++) {
                    {
                        currMap.put(Character.valueOf(substring.charAt(k)), currMap.getOrDefault(Character.valueOf(substring.charAt(k)), 0)+1);
                    }
                }
                for (Character c : map.keySet()) {
                    if(!currMap.containsKey(c) || map.get(c) > currMap.get(c)) {
                        fit = false;
                        break;
                    }
                }
                if(fit && (result.length() == 0 || result.length() > substring.length())) {
                   result = substring;  
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }
}