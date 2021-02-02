package lee.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * description: 224 基本计算器
 *
 * @author JunchaoYao
 * @date 2021-01-28 13:43
 **/
public class Calculate {
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
                    n= n*10 + (c - '0');
                }
                if (c == '(') {
                    n = calculate(s);
                    i = index-1;
                }
                //如果不是数字，或者是最后一位就进行压入堆栈
                if ((!Character.isDigit(c) && c !=' ') || i == s.length() - 1) {
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

//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        System.out.println(solution.calculate("(1+(4+5+2)-3)+(6+8)"));
//    }
}
