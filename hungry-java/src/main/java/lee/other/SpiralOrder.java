package lee.other;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * description: 螺旋矩阵
 *
 * @author JunchaoYao
 * @date 2021-02-01 10:33
 **/
public class SpiralOrder {
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            int m = matrix.length;
            List<Integer> ans = new ArrayList<>();
            if (m == 0) {
                return ans;
            }
            int n = matrix[0].length;
            int top = 0;
            //m是多少行
            int bottom = m - 1;
            int left = 0;
            int right = n - 1;

            int i = 0;
            while (i < m * n) {
                for (int p = left; p <= right && i < m * n; p++) {
                    ans.add(matrix[top][p]);
                    i++;
                }
                top++;
                for (int j = top; j <= bottom && i < m *n; j++) {
                    ans.add(matrix[j][right]);
                    i++;
                }
                right--;
                for (int p = right; p >= left && i < m * n; p--) {
                    ans.add(matrix[bottom][p]);
                    i++;
                }
                bottom--;
                for (int j = bottom; j >=top && i < m *n; j--) {
                    ans.add(matrix[j][left]);
                    i++;
                }
                left++;
            }
            return ans;
        }
    }
}


