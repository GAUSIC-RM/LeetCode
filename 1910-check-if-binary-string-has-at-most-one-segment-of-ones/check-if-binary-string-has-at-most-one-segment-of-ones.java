class Solution {
    public boolean checkOnesSegment(String s) {
        boolean zeroSeen = false;
        for (char c : s.toCharArray()) {
            if (c == '0') {
                zeroSeen = true;
            }
            if (c == '1' && zeroSeen) {
                return false;
            }
        }
        return true;
    }
}