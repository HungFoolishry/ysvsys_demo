//给你一个字符串 s 、一个字符串 t 。
// 返回 s 中涵盖 t 所有字符的最小子串。
// 如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
//
// 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。
//
//
//
// 示例 1：
//
//
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
//
//
// 示例 2：
//
//
//输入：s = "a", t = "a"
//输出："a"
//
//
//
//
// 提示：
//
//
// 1 <= s.length, t.length <= 105
// s 和 t 由英文字母组成
//
//
//
//进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ Related Topics 哈希表 双指针 字符串 Sliding Window
// 👍 989 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        Solution solution = new MinimumWindowSubstring().new Solution();
        System.out.println(solution.minWindow("a", "a"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            Map<Character, Integer> tMap = new HashMap<>();
            Map<Character, Integer> windowMap = new HashMap<>();
            for (int i = 0; i < t.length(); i++) {
                tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
            }
            int l = 0;
            int start = 0;
            int len = Integer.MAX_VALUE;
            for (int i = 0; i < s.length(); i++) {
                windowMap.put(s.charAt(i), windowMap.getOrDefault(s.charAt(i), 0) + 1);
                while (check(tMap, windowMap) && l<=i) {
                    if (i - l + 1 < len) {
                        start = l;
                        len = i - l+1;
                    }
                    windowMap.put(s.charAt(l), windowMap.get(s.charAt(l)) - 1);
                    l++;
                }
            }
            if (len == Integer.MAX_VALUE) {
                return "";
            }
            return s.substring(start, start+len);
        }

        public boolean check(Map<Character, Integer> tMap, Map<Character, Integer> windowMap) {
            for (Character key : tMap.keySet()) {
                if (windowMap.getOrDefault(key, 0)<(tMap.get(key))) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}