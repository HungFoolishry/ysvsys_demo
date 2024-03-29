package lee.other;

import java.util.Arrays;

/**
 * description: 最长公共前缀
 *
 * @author JunchaoYao
 * @date 2020-12-14 19:34
 **/
public class LongestCommonPrefix {
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs ==null || strs.length == 0) {
                return "";
            }
            // TODO 如何在reduce中提早break
            return Arrays.stream(strs).reduce(strs[0], this::compareAndGetPrefix);
        }

        private String compareAndGetPrefix(String pre, String originStr){
            int len = Math.min(pre.length(), originStr.length());
            for (int i = 0; i < len; i++) {
                if (pre.charAt(i) != originStr.charAt(i)) {
                    return pre.substring(0, i);
                }
            }
            return pre.substring(0, len);
        }

    }


    public static void main(String[] args) {
        String[] strs = {"caa", "caab", "caab"};
    }

//    class Solution {
//        public String longestCommonPrefix(String[] strs) {
//            if (strs == null || strs.length == 0) {
//                return "";
//            }
//            String prefix = strs[0];
//            int count = strs.length;
//            for (int i = 1; i < count; i++) {
//                prefix = longestCommonPrefix(prefix, strs[i]);
//                if (prefix.length() == 0) {
//                    break;
//                }
//            }
//            return prefix;
//        }
//
//        public String longestCommonPrefix(String str1, String str2) {
//            int length = Math.min(str1.length(), str2.length());
//            int index = 0;
//            while (index < length && str1.charAt(index) == str2.charAt(index)) {
//                index++;
//            }
//            return str1.substring(0, index);
//        }
//    }


}
