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
        StringBuilder ans = new StringBuilder("");
        int carry = 0;
        public String addStrings(String num1, String num2) {
            int len1 = num1.length();
            int len2 = num2.length();
            int i = len1-1;
            int j = len2-1;
            while (i >= 0 || j >= 0) {
                if (i < 0) {
                    add('0', num2.charAt(j));
                    j--;
                    continue;
                }
                if (j < 0) {
                    add(num1.charAt(i), '0');
                    i--;
                    continue;
                }
                add(num1.charAt(i), num2.charAt(j));
                i--;
                j--;
            }
            if (carry > 0) {
                ans.append(carry);
            }
            return ans.reverse().toString();
        }

        public void add(char char1, char char2) {
            int num1 = char1 - '0';
            int num2 = char2 - '0';
            int sum = num1 + num2+carry;
            carry = sum / 10;
            ans.append(sum % 10);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}