package lee.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * description:  基本计算器II
 *
 * @author JunchaoYao
 * @date 2021-01-28 13:43
 **/
public class CalculateII {
     class Solution {
        public int calculate(String s) {
            int n = 0;
            char sign = '+';
            Deque<Integer> stack = new LinkedList<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (Character.isDigit(c)) {
                    n = n * 10 + (c - '0');
                }
                if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
                    int pre;
                    switch (sign) {
                        case '+' :
                            stack.addFirst(n);
                            break;
                        case '-':
                            stack.addFirst(-n);
                            break;
                        case '*' :
                             pre =  stack.removeFirst();
                            stack.addFirst(pre * n);
                            break;
                        case '/':
                             pre =  stack.removeFirst();
                            stack.addFirst(pre / n);
                            break;
                    }
                    sign = c;
                    n = 0;
                }
            }
            // 求和
            int ans = 0;
            while (!stack.isEmpty()) {
                ans += stack.removeFirst();
            }
            return ans;
        }
    }

//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        System.out.println(solution.calculate(" 3/2"));
//    }
}
