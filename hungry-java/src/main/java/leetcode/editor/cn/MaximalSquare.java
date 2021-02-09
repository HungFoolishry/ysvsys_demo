//在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
//
//
//
// 示例 1：
//
//
//输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"]
//,["1","0","0","1","0"]]
//输出：4
//
//
// 示例 2：
//
//
//输入：matrix = [["0","1"],["1","0"]]
//输出：1
//
//
// 示例 3：
//
//
//输入：matrix = [["0"]]
//输出：0
//
//
//
//
// 提示：
//
//
// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 300
// matrix[i][j] 为 '0' 或 '1'
//
// Related Topics 动态规划
// 👍 661 👎 0


package leetcode.editor.cn;

public class MaximalSquare {
    public static void main(String[] args) {
        Solution solution = new MaximalSquare().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximalSquare(char[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            int ans = 0;
            int[][] dp = new int[m][n];
            for (int i = 0; i < n; i++) {
                if (matrix[0][i] == '1') {
                    dp[0][i] = 1;
                    ans = 1;
                } else {
                    dp[0][i] = 0;
                }
            }
            for (int i = 0; i < m; i++) {
                if (matrix[i][0] == '1') {
                    dp[i][0] = 1;
                    ans = 1;
                } else {
                    dp[i][0] = 0;
                }
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (matrix[i][j]=='1'){
                        dp[i][j] = Math.max(1, Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]),dp[i-1][j-1])+1);
                        if (dp[i][j] > ans) {
                            ans = dp[i][j];
                        }
                    }else {
                        dp[i][j] = 0;
                    }

                }
            }
            return ans * ans;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
