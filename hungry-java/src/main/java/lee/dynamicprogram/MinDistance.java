package lee.dynamicprogram;

/**
 * description: 最少编辑距离 word1 -> word2
 *
 * @author JunchaoYao
 * @date 2021-01-19 16:03
 **/
public class MinDistance {
    class Solution {
        public int minDistance(String word1, String word2) {
            char[] word1Arr = word1.toCharArray();
            char[] word2Arr = word2.toCharArray();
            int[][] dp = new int[word1.length() + 1][word2.length() + 1];
            dp[0][0] = 0;
            for (int i = 1; i <= word1Arr.length; i++) {
                dp[i][0] = dp[i - 1][0] + 1;
            }

            for (int i = 1; i <= word2Arr.length; i++) {
                dp[0][i] = dp[0][i - 1] + 1;
            }
            for (int i = 1; i < word1Arr.length+1; i++) {
                for (int j = 1; j < word2Arr.length+1; j++) {
                    if (word1Arr[i-1] == word2Arr[j-1]) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
                    }
                }
            }
            return dp[word1.length()][word2.length()];
        }
    }
}
