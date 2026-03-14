import java.util.*;
class Solution {
    int count = 0;
    String result = "";
    public String getHappyString(int n, int k) {
        backtrack("", n, k);
        return result;
    }
    private void backtrack(String current, int n, int k) {
        if (current.length() == n) {
            count++;
            if (count == k)
                result = current;
            return;
        }
        for (char c : new char[]{'a','b','c'}) {
            if (current.length() > 0 && current.charAt(current.length() - 1) == c)
                continue;
            backtrack(current + c, n, k);
            if (!result.equals(""))
                return;
        }
    }
}