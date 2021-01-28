package lee.dynamicprogram;

import java.util.ArrayList;
import java.util.List;

/**
 * description: 爬楼梯
 *
 * @author JunchaoYao
 * @date 2020-12-23 11:32
 **/
public class ClimbStairs {
    class Solution {
        public int climbStairs(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i < n + 1; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];

        }
    }
}
