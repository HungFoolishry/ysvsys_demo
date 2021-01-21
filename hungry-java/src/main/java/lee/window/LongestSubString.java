package lee.window;

import java.util.HashMap;
import java.util.Map;

/**
 * description: 核心点在于看到'不重复'要想到hash map去存储历史key；双指针法
 *
 * @author JunchaoYao
 * @date 2020-08-13 23:52
 **/
public class LongestSubString {
    public static int lengthOfLongestSubstring(String s) {
        int end = 0;
        int start = 0;
        int n = s.length();
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (end = 0; end < n; end++) {
            Character endChar = s.charAt(end);
            if (map.containsKey(endChar)) {
                start = Math.max(map.get(endChar) + 1, start); //此行是关键，取重复历史的key的下标与本次的start下标比，start取最大结果，保证了start必须增加，不能后退
            }
            map.put(endChar, end);
            max = Math.max(max, end - start + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("dvdf"));
        System.out.println(lengthOfLongestSubstring("abba"));
    }
}
