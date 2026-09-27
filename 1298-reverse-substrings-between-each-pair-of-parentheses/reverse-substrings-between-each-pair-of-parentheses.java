import java.util.*;
class Solution {
    public String reverseParentheses(String s) {
        Deque<String> stack = new ArrayDeque<>();
        StringBuilder current = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(current.toString());
                current.setLength(0);
            }
            else if (ch == ')') {
                current.reverse();
                current.insert(0, stack.pop());
            }
            else {
                current.append(ch);
            }
        }
        return current.toString();
    }
}