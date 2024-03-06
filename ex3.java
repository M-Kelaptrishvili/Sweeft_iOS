import java.util.ArrayList;
import java.util.List;

public class ex3 {

    public static boolean wordBreak(String s, List<String> wordDict) {
        if(s.length()==0) return true;
        if(wordDict.contains(s)) return true;
        if(s.length()==1 && !wordDict.contains(s)) return false;
        for (int i = 0; i < s.length(); i++) {
            if(wordDict.contains(s.substring(0, i)) && wordBreak(s.substring(i), wordDict)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> t = new ArrayList<>();
        t.add("leet");
        t.add("code");
        System.out.println(wordBreak(s, t));
    }
}