//给你一个字符串 s，找到 s 中最长的回文子串。
//
//
//
// 示例 1：
//
//
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
//
//
// 示例 2：
//
//
//输入：s = "cbbd"
//输出："bb"
//
//
// 示例 3：
//
//
//输入：s = "a"
//输出："a"
//
//
// 示例 4：
//
//
//输入：s = "ac"
//输出："a"
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 1000
// s 仅由数字和英文字母（大写和/或小写）组成
//
// Related Topics 字符串 动态规划
// 👍 3209 👎 0


package leetcode.editor.cn;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            int n = s.length();
            if (n < 2) {
                return s;
            }
            int start = 0;
            int maxLen = 1;
            //  只需要n，并且dp i j 的概念是 i-j 字符串是否是回文
            int[][] dp = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int i = 0; i <= j; i++) {
                    if (s.charAt(i) == s.charAt(j)) {
                        if (j - i + 1 <= 3) {
                            dp[i][j] = 1;
                        } else {
                            dp[i][j] = dp[i + 1][j - 1];
                        }
                    } else {
                        dp[i][j] = 0;
                    }
                    if (dp[i][j] == 1 && j - i + 1 > maxLen) {
                        start = i;
                        maxLen = j - i + 1;
                    }
                }
            }

            return s.substring(start, start + maxLen);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}