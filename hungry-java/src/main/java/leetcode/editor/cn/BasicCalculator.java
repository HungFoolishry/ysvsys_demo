//给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
//
//
//
// 示例 1：
//
//
//输入：s = "1 + 1"
//输出：2
//
//
// 示例 2：
//
//
//输入：s = " 2-1 + 2 "
//输出：3
//
//
// 示例 3：
//
//
//输入：s = "(1+(4+5+2)-3)+(6+8)"
//输出：23
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 3 * 105
// s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
// s 表示一个有效的表达式
//
// Related Topics 栈 数学
// 👍 523 👎 0


package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class BasicCalculator {
    public static void main(String[] args) {
        Solution solution = new BasicCalculator().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int index = 0;
        public int calculate(String s) {
            int n = 0;
            char sign = '+';
            Deque<Integer> stack = new LinkedList<>();
            for (int i = index; i < s.length(); i++) {
                char c = s.charAt(i);
                index++;
                //如果是数字则累加
                if (Character.isDigit(c)) {
                    n = n * 10 + (c - '0');
                }
                // 如果是左括号则递归
                if (c == '(') {
                    n = calculate(s);
                    i = index - 1;
                }
                //如果是运算符，或者是最后一位就进行压入堆栈, 放到最后计算
                if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
                    switch (sign) {
                        case '+':
                            stack.addFirst(n);
                            break;
                        case '-':
                            stack.addFirst(-n);
                            break;
                        case '*':
                            stack.addFirst(stack.getFirst() * n);
                            break;
                        case '/':
                            stack.addFirst(stack.getFirst() / n);
                            break;
                    }
                    //取当前符号，如果是最后一位则有可能不是符号
                    sign = c;
                    //初始化累加器
                    n = 0;
                }
                if (c == ')') {
                    break;
                }

            }
            int ans = 0;
            while (!stack.isEmpty()) {
                ans += stack.removeFirst();
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}