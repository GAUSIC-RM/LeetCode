class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] masks = new int[n];
        for (int i = 0; i < n; i++) {
            int mask = 0;
            for (char ch : words[i].toCharArray()) {
                mask |= 1 << (ch - 'a');
            }
            masks[i] = mask;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((masks[i] & masks[j]) == 0) {
                    ans = Math.max(ans,
                            words[i].length() * words[j].length());
                }
            }
        }
        return ans;
    }
}