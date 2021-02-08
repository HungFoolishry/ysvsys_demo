package lee.window;

import javax.sound.midi.Soundbank;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * description: 最小覆盖子串
 *
 * @author JunchaoYao
 * @date 2021-02-04 16:38
 **/
public class MinWindow {
    static class Solution {
        public String minWindow(String s, String t) {
            int tLen = t.length();
            int sLen = s.length();
            Map<Character, Integer> tMap = new HashMap<>();
            Map<Character, Integer> windowMap = new HashMap<>();
            for (int i = 0; i < tLen; i++) {
                int f = tMap.getOrDefault(t.charAt(i), 0);
                f++;
                tMap.put(t.charAt(i), f);
            }
            int left = 0;
            int right = 0;
            int ansL = 0;
            int ansR = Integer.MAX_VALUE;
            boolean hasAns = false;
            updateWindowMap(tMap, windowMap, s, right, true);
            while (left <= right && left < sLen && right < sLen) {
                hasAns = check(tMap, windowMap);
                if (!hasAns) {
                    right++;
                    updateWindowMap(tMap, windowMap, s, right, true);
                }else {
                    if (right - left < ansR - ansL) {
                        ansL = left;
                        ansR = right;
                    }
                    left++;
                    updateWindowMap(tMap, windowMap, s, left-1, false);

                }
            }
            if (ansR-ansL <= sLen) {
                return s.substring(ansL, ansR+1);
            }
            return "";
        }

        private void updateWindowMap(Map<Character, Integer> tMap, Map<Character, Integer> wMap, String s, Integer i, boolean doAdd) {
            if ( i >= s.length() || !tMap.containsKey(s.charAt(i))) {
                return;
            }
            int f = wMap.getOrDefault(s.charAt(i), 0);
            if (doAdd) {
                f++;
            } else {
                f--;
            }
            wMap.put(s.charAt(i), f);
        }
        private  boolean check(Map<Character, Integer> tMap, Map<Character, Integer> wMap){
            for (Character k : tMap.keySet()) {
                int tmpF = wMap.getOrDefault(k, 0);
                if (tmpF < tMap.get(k)) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minWindow("ADOBECODEBANC","ABC"));
    }

}
