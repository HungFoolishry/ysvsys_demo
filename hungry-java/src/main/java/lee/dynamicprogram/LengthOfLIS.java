package lee.dynamicprogram;

import java.util.Arrays;

/**
 * description: 最长递增子序列
 *
 * @author JunchaoYao
 * @date 2021-01-19 10:23
 **/
public class LengthOfLIS {
    class Solution {
        public int lengthOfLIS(int[] nums) {
            int[] dp = new int[nums.length];
            Arrays.fill(dp, 1);
            int max = 1;
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j] && dp[j]+1>dp[i]) {
                        dp[i] = dp[j] + 1;
                        if (dp[i] > max) {
                            max = dp[i];
                        }
                    }

                }
            }
            return max;

        }
    }
}
