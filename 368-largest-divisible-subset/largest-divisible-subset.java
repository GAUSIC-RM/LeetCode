import java.util.*;
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<Integer>[] dp = new ArrayList[n];
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            dp[i] = new ArrayList<>();
            dp[i].add(nums[i]);
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 &&
                    dp[j].size() + 1 > dp[i].size()) {
                    dp[i] = new ArrayList<>(dp[j]);
                    dp[i].add(nums[i]);
                }
            }
            if (dp[i].size() > answer.size()) {
                answer = dp[i];
            }
        }
        return answer;
    }
}