//编写一个函数来查找字符串数组中的最长公共前缀。
//
// 如果不存在公共前缀，返回空字符串 ""。
//
//
//
// 示例 1：
//
//
//输入：strs = ["flower","flow","flight"]
//输出："fl"
//
//
// 示例 2：
//
//
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。
//
//
//
// 提示：
//
//
// 0 <= strs.length <= 200
// 0 <= strs[i].length <= 200
// strs[i] 仅由小写英文字母组成
//
// Related Topics 字符串
// 👍 1446 👎 0


package leetcode.editor.cn;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            StringBuilder ans = new StringBuilder("");
            for (int i = 0; i < 201; i++) {
                Character tmp = null;
                for (String s : strs) {
                    if (i > s.length() - 1) {
                        return ans.toString();
                    }
                    if (tmp == null) {
                        tmp = s.charAt(i);
                    }
                    if ( tmp != s.charAt(i)) {
                        return ans.toString();
                    }
                }
                if (tmp != null) {
                    ans.append(tmp);
                }
            }
            return ans.toString();

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}