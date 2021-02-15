//给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如
//同俄罗斯套娃一样。
//
// 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
//
// 说明:
//不允许旋转信封。
//
// 示例:
//
// 输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
//输出: 3
//解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
//
// Related Topics 二分查找 动态规划
// 👍 268 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

public class RussianDollEnvelopes {
    public static void main(String[] args) {
        Solution solution = new RussianDollEnvelopes().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxEnvelopes(int[][] envelopes) {

            int m = envelopes.length;
            int ans = 1;
            Arrays.sort(envelopes, (a,b)-> a[0]*a[1] - b[0]*b[1]);
            int[] dp = new int[m];
            Arrays.fill(dp, 1);
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < i; j++) {
                    if (envelopes[i][0]>envelopes[j][0]&&envelopes[i][1]>envelopes[j][1]) {
                        dp[i] = Math.max(dp[j] + 1, dp[i]);
                    }
                }
            }
            for (int i = 0; i < dp.length; i++) {
                ans = Math.max(dp[i], ans);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}