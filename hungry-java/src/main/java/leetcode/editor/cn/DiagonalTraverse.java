//给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。
//
//
//
// 示例:
//
// 输入:
//[
// [ 1, 2, 3 ],
// [ 4, 5, 6 ],
// [ 7, 8, 9 ]
//]
//
//输出:  [1,2,4,7,5,3,6,8,9]
//
//解释:
//
//
//
//
//
// 说明:
//
//
// 给定矩阵中的元素总数不会超过 100000 。
//
// 👍 175 👎 0


package leetcode.editor.cn;

public class DiagonalTraverse {
    public static void main(String[] args) {
        Solution solution = new DiagonalTraverse().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
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
                int y2 = i < n ? i : n - 1;
                int x2 = i - y2;
                while (y2 >= 0 && x2 < m) {
                    ans[k++] = matrix[x2++][y2--];
                }
                i++;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}