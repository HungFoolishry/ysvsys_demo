//给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
//
// 注意:
//
//
// num 的长度小于 10002 且 ≥ k。
// num 不会包含任何前导零。
//
//
// 示例 1 :
//
//
//输入: num = "1432219", k = 3
//输出: "1219"
//解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
//
//
// 示例 2 :
//
//
//输入: num = "10200", k = 1
//输出: "200"
//解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
//
//
// 示例 3 :
//
//
//输入: num = "10", k = 2
//输出: "0"
//解释: 从原数字移除所有的数字，剩余为空就是0。
//
// Related Topics 栈 贪心算法
// 👍 516 👎 0


package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class RemoveKDigits {
    public static void main(String[] args) {
        Solution solution = new RemoveKDigits().new Solution();
        System.out.println(solution.removeKdigits("1432219", 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 核心在于单调栈，每个入栈的数字必须保证自己比前面的数字大，不然就pop前面的数字
        public String removeKdigits(String num, int k) {
            // 考虑 字符全部被删除
            if (k >= num.length()) {
                return "0";
            }
            Deque<Character> stack = new LinkedList<>();
            for (int i = 0; i < num.length(); i++) {
                if (!stack.isEmpty())  {
                    if (stack.peek() > num.charAt(i)&& k> 0) {
                        stack.pop();
                        k--;
                        //核心步骤，不许循环去找前面比自己大的数字，因为排前面才影响最大
                        while (!stack.isEmpty() && stack.peek() > num.charAt(i) && k > 0) {
                            stack.pop();
                            k--;
                        }
                    }
                }
                if (stack.isEmpty()) {
                    if (num.charAt(i) != '0') {
                        stack.push(num.charAt(i));
                    }
                } else {
                    stack.push(num.charAt(i));
                }

            }
            StringBuilder builder = new StringBuilder("");
            while (!stack.isEmpty()) {
                if (k > 0) {
                    stack.pop();
                    k--;
                } else {
                    builder.append(stack.pop());
                }
            }
            if (builder.length() == 0) {
                return "0";
            }
            return builder.reverse().toString();
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}