class Solution {
    public int minOperations(String s) {
        int count1 = 0; 
        int count2 = 0; 
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char expected1 = (i % 2 == 0) ? '0' : '1';
            if (c != expected1) count1++;
            char expected2 = (i % 2 == 0) ? '1' : '0';
            if (c != expected2) count2++;
        }
        return Math.min(count1, count2);
    }
}