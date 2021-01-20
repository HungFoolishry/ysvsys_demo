package lee.dynamicprogram;

/**
 * description: 打家劫舍
 *
 * @author JunchaoYao
 * @date 2021-01-20 10:28
 **/
public class Rob {
    class Solution {
        public int rob(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            if (nums.length == 1) {
                return nums[0];
            }
            if (nums.length == 2) {
                return  Math.max(nums[0], nums[1]);
            }
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);
            dp[2] = Math.max(nums[0] + nums[2], nums[1]);
            int max = dp[2];
            for (int i = 3; i < nums.length; i++) {
                //一定偷第k间房子
                dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 3] + nums[i]);
                if (dp[i] > max) {
                    max = dp[i];
                }
            }
            return max;

        }
    }
/*    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        // 一定不偷第k间房子
        // 子问题：
        // f(k) = 偷 [0..k) 房间中的最大金额

        // f(0) = 0
        // f(1) = nums[0]
        // f(k) = max{ rob(k-1), nums[k-1] + rob(k-2) }

        int N = nums.length;
        int[] dp = new int[N+1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int k = 2; k <= N; k++) {
            dp[k] = Math.max(dp[k-1], nums[k-1] + dp[k-2]);
        }
        return dp[N];
    }*/

}
