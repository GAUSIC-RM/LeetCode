import java.util.*;
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        backtrack(s, wordDict, "", result);
        return result;
    }
    private void backtrack(String s,
                           List<String> wordDict,
                           String sentence,
                           List<String> result) {
        if (s.length() == 0) {
            result.add(sentence.trim());
            return;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                backtrack(
                    s.substring(word.length()),
                    wordDict,
                    sentence + word + " ",
                    result
                );
            }
        }
    }
}