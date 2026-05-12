import java.util.*;
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));
        paragraph = paragraph.toLowerCase().replaceAll("[!?',;.]", " ");
        String[] words = paragraph.split("\\s+");
        Map<String, Integer> freq = new HashMap<>();
        String answer = "";
        int maxCount = 0;
        for (String word : words) {
            if (!bannedSet.contains(word) && !word.isEmpty()) {
                int count = freq.getOrDefault(word, 0) + 1;
                freq.put(word, count);
                if (count > maxCount) {
                    maxCount = count;
                    answer = word;
                }
            }
        }
        return answer;
    }
}