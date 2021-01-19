package lee.dynamicprogram;

import java.util.Arrays;

/**
 * description: 最长公共子序列 非连续
 *
 * @author JunchaoYao
 * @date 2021-01-19 16:20
 **/
public class LongestCommonSubsequence {
    class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            char[] text1List = text1.toCharArray();
            char[] text2List = text2.toCharArray();
            int[][] dp = new int[text1.length() + 1][text2.length() + 1];
            for (int i = 1; i <=text1List.length; i++) {
                for (int j = 1; j <= text2List.length; j++) {
                    if (text1List[i-1] == text2List[j-1]) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }

                }

            }
            return dp[text1List.length][text2List.length];
        }
    }
}
