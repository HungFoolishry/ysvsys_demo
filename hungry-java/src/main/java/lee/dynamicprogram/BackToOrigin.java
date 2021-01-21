package lee.dynamicprogram;

/**
 * description: 返回圆环起点
 *
 * @author JunchaoYao
 * @date 2021-01-21 10:25
 **/
public class BackToOrigin {
    class Solution {
        public int backToOrigin(int n) {
            int len = 10;
            int[][] dp = new int[n + 1][len];
            dp[0][0] = 1;
            for (int i = 1; i < n + 1; i++) {
                for (int j = 0; j < len; j++) {
                    dp[i][j] = dp[i - 1][(j - 1 + len) % len] + dp[i - 1][(j + 1) % len];
                }
            }
            return dp[n + 1][0];
        }
    }
}
//    class Solution:
//      def backToOrigin(self,n):
//            #点的个数为10
//            length = 10
//          dp = [[0 for i in range(length)] for j in range(n+1)]
//          dp[0][0] = 1
//              for i in range(1,n+1):
//                  for j in range(length):
//                  #dp[i][j]表示从0出发，走i步到j的方案数
//                      dp[i][j] = dp[i-1][(j-1+length)%length] + dp[i-1][(j+1)%length]
//          return dp[n][0]


