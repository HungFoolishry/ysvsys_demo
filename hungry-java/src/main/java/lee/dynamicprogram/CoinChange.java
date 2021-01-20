package lee.dynamicprogram;

import java.util.Arrays;

/**
 * description: 零钱兑换
 *
 * @author JunchaoYao
 * @date 2021-01-20 10:55
 **/
public class CoinChange {
    class Solution {
        public int coinChange(int[] coins, int amount) {
            int[] dp = new int[amount + 1];
            int max = amount + 1;
            Arrays.fill(dp, max);
            dp[0] = 0;
            for (int i = 0; i < amount + 1; i++) {
                for (int coin : coins) {
                    // 只有剩余的目标大于金币数目才能进行扣钱
                    if (i >= coin) {
                        dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
                    }
                }
            }
            return dp[amount] >=max?-1:dp[amount];

        }
    }
}
