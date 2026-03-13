import java.util.*;
class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long left = 0;
        long right = (long)1e18;
        long ans = right;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (canReduce(mid, mountainHeight, workerTimes)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
    private boolean canReduce(long time, int height, int[] workers) {
        long total = 0;
        for (int w : workers) {
            long left = 0, right = 100000;
            while (left <= right) {
                long mid = (left + right) / 2;
                long required = (long) w * mid * (mid + 1) / 2;
                if (required <= time) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            total += right;
            if (total >= height)
                return true;
        }
        return false;
    }
}