//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//
//
//
// 示例 1：
//
//
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
//
//
// 示例 2：
//
//
//输入：n = 1
//输出：["()"]
//
//
//
//
// 提示：
//
//
// 1 <= n <= 8
//
// Related Topics 字符串 回溯算法
// 👍 1578 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> ans = new ArrayList<>();
        int max;

        public List<String> generateParenthesis(int n) {
            max = n;
            back(new StringBuffer(""), 0, 0);
            return ans;
        }

        public void back(StringBuffer tmp, int open, int close) {
            if (tmp.length() == max * 2) {
                ans.add(tmp.toString());
                return;
            }
            if (open < max) {
                tmp.append('(');
                back(tmp, open+1, close);
                tmp.deleteCharAt(tmp.length() - 1);
            }
            if (close < open) {
                tmp.append(')');
                back(tmp, open, close+1);
                tmp.deleteCharAt(tmp.length() - 1);
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}