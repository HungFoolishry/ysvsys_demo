//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
//
//
//
// 示例 1：
//
//
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
//
//
// 示例 2：
//
//
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
//
//
//
//
// 提示：
//
//
// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 10
// -100 <= matrix[i][j] <= 100
//
// Related Topics 数组
// 👍 607 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        Solution solution = new SpiralMatrix().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            int m = matrix.length;
            if (m == 0) {
                return new ArrayList<>();
            }
            int n = matrix[0].length;
            int top = 0;
            int bottom = m - 1;
            int left = 0;
            int right = n-1;
            List<Integer> ans = new ArrayList<>();
            while (ans.size() < m * n) {
                for (int i = left; i <= right&&ans.size() < m * n; i++) {
                    ans.add(matrix[top][i]);
                }
                top++;
                for (int i = top; i <= bottom&&ans.size() < m * n; i++) {
                    ans.add(matrix[i][right]);
                }
                right--;

                for (int i = right; i >= left&&ans.size() < m * n; i--) {
                    ans.add(matrix[bottom][i]);
                }
                bottom--;

                for (int i = bottom; i >= top&&ans.size() < m * n; i--) {
                    ans.add(matrix[i][left]);
                }
                left++;

            }
            return ans;


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}