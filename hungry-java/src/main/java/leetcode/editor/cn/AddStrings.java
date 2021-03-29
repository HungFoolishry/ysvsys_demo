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
        System.out.println(solution.addStrings("1b","2a"));
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
                int x = i >= 0 ? getInt(num1.charAt(i)) : 0;
                int y = i >= 0 ? getInt(num2.charAt(j)) : 0;
                int tmp = x + y + carry;
                ans.append(getChar((tmp) % 36));
                carry = tmp / 36;
                i--;
                j--;
            }
            if (carry > 0) {
                ans.append(getChar(carry));
            }
            return ans.reverse().toString();
        }

        public int getInt(char ch) {
            if (ch >= '0' && ch <= '9') {
                return ch - '0';
            } else {
                return ch - 'a' + 10;
            }
        }

        public char getChar(int i) {
            if (i >= 0 && i <= 9) {
                return (char) ('0' + i);
            } else {
                return (char) (i - 10 + 'a');
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}