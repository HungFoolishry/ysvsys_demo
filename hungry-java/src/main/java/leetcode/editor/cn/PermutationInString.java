//给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
//
// 换句话说，第一个字符串的排列之一是第二个字符串的子串。
//
// 示例1:
//
//
//输入: s1 = "ab" s2 = "eidbaooo"
//输出: True
//解释: s2 包含 s1 的排列之一 ("ba").
//
//
//
//
// 示例2:
//
//
//输入: s1= "ab" s2 = "eidboaoo"
//输出: False
//
//
//
//
// 注意：
//
//
// 输入的字符串只包含小写字母
// 两个字符串的长度都在 [1, 10,000] 之间
//
// Related Topics 双指针 Sliding Window
// 👍 231 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class PermutationInString {
    public static void main(String[] args) {
        Solution solution = new PermutationInString().new Solution();
        System.out.println(solution.checkInclusion("ab", "eidbaooo"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            if (s2.length() < s1.length()) {
                return false;
            }
            Map<Character, Integer> tMap = new HashMap<>();
            Map<Character, Integer> wMap = new HashMap<>();

            for (int i = 0; i < s1.length(); i++) {
                tMap.put(s1.charAt(i), tMap.getOrDefault(s1.charAt(i), 0) + 1);
                wMap.put(s2.charAt(i), wMap.getOrDefault(s2.charAt(i), 0) + 1);

            }
            int l = 0;
            int r = s1.length() - 1;
            while (r < s2.length()) {
                if (checkMap(tMap, wMap)) {
                    return true;
                }
                wMap.put(s2.charAt(l), wMap.get(s2.charAt(l)) - 1);
                l++;
                r++;
                if (r >= s2.length()) {
                    break;
                }
                wMap.put(s2.charAt(r), wMap.getOrDefault(s2.charAt(r), 0) + 1);
            }
            return false;
        }

        public boolean checkMap(Map<Character, Integer> tMap, Map<Character, Integer> wMap) {
            for (Character key : wMap.keySet()) {
                if (!wMap.get(key).equals(tMap.getOrDefault(key, 0))) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}