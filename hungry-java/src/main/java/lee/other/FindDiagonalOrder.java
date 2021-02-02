package lee.other;

/**
 * description: 对角矩阵遍历
 *
 * @author JunchaoYao
 * @date 2021-02-02 17:58
 **/
public class FindDiagonalOrder {
    class Solution {
        public int[] findDiagonalOrder(int[][] matrix) {
            // x 是行
            int m = matrix.length;
            if (m == 0) {
                return new int[0];
            }
            //y 是列
            int n = matrix[0].length;
            int[] ans = new int[m * n];
            //x+y = i
            int i = 0;
            int k = 0;
            while (i < m + n) {
                int x1 = i < m ? i : m - 1;
                int y1 = i - x1;
                while (x1 >= 0 && y1 < n) {
                    ans[k++] = matrix[x1--][y1++];
                }
                i++;
                if (i >= m + n) {
                    break;
                }
                int y2 = i < n ? i : n -1;
                int x2 = i - y2;
                while (y2 >= 0 && x2<m) {
                    ans[k++] = matrix[x2++][y2--];
                }
                i++;
            }
            return ans;
        }
    }
}
