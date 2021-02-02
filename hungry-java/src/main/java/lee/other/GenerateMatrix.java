package lee.other;

import java.util.Arrays;

/**
 * description: 生成螺旋矩阵
 *
 * @author JunchaoYao
 * @date 2021-02-02 19:51
 **/
public class GenerateMatrix {
    class Solution {
        public int[][] generateMatrix(int n) {
            int[][] ans = new int[n][n];
            if (n == 0) {
                return ans;
            }
            int i = 1;
            int top = 0;
            int left = 0;
            int right = n - 1;
            int bottom = n - 1;
            while (i <= n * n) {
                for (int j = left; j <= right &&i <= n * n; j++) {
                    ans[top][j] = i++;
                }
                top++;
                for (int j = top; j <= bottom &&i <= n * n; j++) {
                    ans[j][right] = i++;
                }
                right--;
                for (int j = right; j >= left &&i <= n * n; j--) {
                    ans[bottom][j] = i++;
                }
                bottom--;
                for (int j = bottom; j >=top  &&i <= n * n; j--) {
                    ans[j][left] = i++;
                }
                left++;
            }
            return ans;
        }
    }

}
