//给定一个二维网格和一个单词，找出该单词是否存在于网格中。
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
//
//
//
// 示例:
//
// board =
//[
//  ['A','B','C','E'],
//  ['S','F','C','S'],
//  ['A','D','E','E']
//]
//
//给定 word = "ABCCED", 返回 true
//给定 word = "SEE", 返回 true
//给定 word = "ABCB", 返回 false
//
//
//
// 提示：
//
//
// board 和 word 中只包含大写和小写英文字母。
// 1 <= board.length <= 200
// 1 <= board[i].length <= 200
// 1 <= word.length <= 10^3
//
// Related Topics 数组 回溯算法
// 👍 804 👎 0


package leetcode.editor.cn;

public class WordSearch {
    public static void main(String[] args) {
        Solution solution = new WordSearch().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        boolean ans = false;
        int[][] path;
        int index = 0;

        public boolean exist(char[][] board, String word) {
            int m = board.length;
            int n = board[0].length;
            path = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == word.charAt(0)) {
                        back(board, i, j, word);
                        if (ans) {
                            return ans;
                        }
                    }
                }
            }
            return ans;
        }

        public void back(char[][] board, int i, int j, String word) {
            if (ans) {
                return;
            }
            if (index>=word.length() || i >= board.length || i < 0 || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index) || path[i][j] == 1) {
                return;
            }
            if (board[i][j] == word.charAt(index) && index == word.length() - 1) {
                ans = true;
                return;
            }
            path[i][j] = 1;
            index++;
            back(board, i + 1, j, word);
            back(board, i, j + 1, word);
            back(board, i - 1, j, word);
            back(board, i, j - 1, word);
            index--;
            path[i][j] = 0;


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}