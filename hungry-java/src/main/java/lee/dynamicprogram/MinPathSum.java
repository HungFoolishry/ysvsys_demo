package lee.dynamicprogram;

/**
 * description:
 *
 * @author JunchaoYao
 * @date 2021-01-19 11:14
 **/
public class MinPathSum {
    class Solution {
        public int minPathSum(int[][] grid) {
            int rowsLen = grid.length;
            int colLen = grid[0].length;
            int[][] dp = new int[rowsLen][colLen];
            dp[0][0] = grid[0][0];
            for (int i = 1; i < rowsLen; i++) {
                dp[i][0] = dp[i - 1][0] + grid[i][0];
            }
            for (int i = 1; i < colLen; i++) {
                dp[0][i] = dp[0][i - 1] + grid[0][i];
            }
            for (int i = 1; i < rowsLen; i++) {
                for (int j = 1; j < colLen; j++) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }
            return dp[rowsLen - 1][colLen - 1];
        }
    }
}
