package lee.dynamicprogram;

import java.util.Arrays;

/**
 * description: 最长回文串
 *
 * @author JunchaoYao
 * @date 2021-01-18 22:20
 *  babad
 * b1
 * a01
 * b101
 * a01 1
 * d000 1
 *
 **/
public class LongestPalindrome {
     class Solution {
        public String longestPalindrome(String s) {
            int[][] dp = new int[s.length()][s.length()];
            for (int i = 0; i < s.length(); i++) {
                dp[i][i] = 1;
            }
            int index = 0;
            int maxLen = 1;
            for (int i = 0; i < s.length(); i++) {
                for (int j = 0; j < i; j++) {
                    if (s.charAt(i) != s.charAt(j)) {
                        dp[i][j] = 0;
                    } else {
                        if (i - j <= 2) {
                            dp[i][j] = 1;
                        } else if (dp[i - 1][j + 1] == 1) {
                            dp[i][j] = 1;
                        } else {
                            dp[i][j] = 0;
                        }
                    }
                    if ( dp[i][j] == 1&& i - j +1 > maxLen) {
                        index = j;
                        maxLen = i - j+1;
                    }
            }}
            return s.substring(index, index+maxLen);

        }
    }
//
//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        System.out.println(solution.longestPalindrome("babad"));
//    }
/*public class Solution {

    public String longestPalindrome(String s) {
        // 特判
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;

        // dp[i][j] 表示 s[i, j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        char[] charArray = s.toCharArray();

        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要 dp[i][j] == true 成立，就表示子串 s[i..j] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}*/

}
