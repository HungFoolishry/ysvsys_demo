package lee.other;

/**
 * description: 搜索矩阵
 *
 * @author JunchaoYao
 * @date 2021-02-02 20:12
 **/
public class SearchMatrix {
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int m = matrix.length;
            int n = matrix[0].length;
            int x = m - 1;
            int y = 0;

            while (x >= 0 && y < n) {
                if (matrix[x][y] == target) {
                    return true;
                } else if (matrix[x][y] > target) {
                    x--;
                } else {
                    y++;
                }
            }
            return false;
        }
    }
}
