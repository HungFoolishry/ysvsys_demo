//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
//
//
//
// 提示：
//
//
// num1 和num2 的长度都小于 5100
// num1 和num2 都只包含数字 0-9
// num1 和num2 都不包含任何前导零
// 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式
//
// Related Topics 字符串
// 👍 309 👎 0


package leetcode.editor.cn;

public class AddStrings {
    public static void main(String[] args) {
        Solution solution = new AddStrings().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addStrings(String num1, String num2) {
            StringBuilder ans = new StringBuilder("");
            int len1 = num1.length();
            int len2 = num2.length();
            int i = len1-1;
            int j = len2-1;
            int carry = 0;
            while (i >=0 || j >=0) {
                int sum = carry;
                if (i >= 0) {
                    sum += num1.charAt(i) - '0';
                    i--;
                }
                if (j >= 0) {
                    sum += num2.charAt(j) - '0';
                    j--;
                }
                ans.append(sum % 10);
                carry = sum / 10;

            }
            if (carry > 0) {
                ans.append(carry);
            }
            return ans.reverse().toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}