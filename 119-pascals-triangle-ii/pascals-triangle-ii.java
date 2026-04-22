import java.util.*;
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        long prev = 1;
        result.add(1); 
        for (int k = 1; k <= rowIndex; k++) {
            long curr = prev * (rowIndex - k + 1) / k;
            result.add((int) curr);
            prev = curr;
        }
        return result;
    }
}