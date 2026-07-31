import java.util.*;
class Solution {
    public int minimumPushes(String word) {
        int[] freq = new int[26];
        for (char ch : word.toCharArray()) {
            freq[ch - 'a']++;
        }
        Integer[] arr = new Integer[26];
        for (int i = 0; i < 26; i++) {
            arr[i] = freq[i];
        }
        Arrays.sort(arr, Collections.reverseOrder());
        int pushes = 0;
        for (int i = 0; i < 26; i++) {
            if (arr[i] == 0) break;
            int cost = (i / 8) + 1;
            pushes += arr[i] * cost;
        }
        return pushes;
    }
}