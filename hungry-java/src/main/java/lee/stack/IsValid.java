package lee.stack;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * description: 有效括号
 *
 * @author JunchaoYao
 * @date 2020-12-15 19:12
 **/
public class IsValid {
    static class Solution {
        public boolean isValid(String s) {
            int n = s.length();
            if (n % 2 == 1) {
                return false;
            }
            LinkedList<Character> stack = new LinkedList<>();
            Map<Character, Character> pairs = new HashMap<>();
            pairs.put('{', '}');
            pairs.put('[', ']');
            pairs.put('(', ')');
            char[] charList = s.toCharArray();
            for (Character c : charList) {
                if (pairs.containsKey(c)) {
                    stack.push(c);
                    continue;
                }
                Character head = stack.pollFirst();
                if (head == null || !pairs.get(head).equals(c)) {
                    return Boolean.FALSE;
                }
            }
            if (!stack.isEmpty()) {
                return Boolean.FALSE;
            }
            return Boolean.TRUE;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid(""));

    }
    class Solution {
        public boolean isValid(String s) {
            int n = s.length();
            if (n % 2 == 1) {
                return false;
            }

            Map<Character, Character> pairs = new HashMap<Character, Character>() {{
                put(')', '(');
                put(']', '[');
                put('}', '{');
            }};
            Deque<Character> stack = new LinkedList<Character>();
            for (int i = 0; i < n; i++) {
                char ch = s.charAt(i);
                if (pairs.containsKey(ch)) {
                    if (stack.isEmpty() || !stack.peek().equals(pairs.get(ch))) {
                        return false;
                    }
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }
            return stack.isEmpty();
        }
    }

}
