//给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
//
// 示例 1 :
//
//
//输入: 2736
//输出: 7236
//解释: 交换数字2和数字7。
//
//
// 示例 2 :
//
//
//输入: 9973
//输出: 9973
//解释: 不需要交换。
//
//
// 注意:
//
//
// 给定数字的范围是 [0, 108]
//
// Related Topics 数组 数学
// 👍 150 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

public class MaximumSwap {
    public static void main(String[] args) {
        Solution solution = new MaximumSwap().new Solution();
        System.out.println(solution.maximumSwap(9973));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    public class Solution {

        public int maximumSwap(int num) {
            String s = String.valueOf(num);
            int len = s.length();
            char[] charArray = s.toCharArray();

            // 记录每个数字出现的最后一次出现的下标
            int[] last = new int[10];
            for (int i = 0; i < len; i++) {
                last[charArray[i] - '0'] = i;
            }

            // 从左向右扫描，找到当前位置右边的最大的数字并交换
            for (int i = 0; i < len - 1; i++) {
                // 找最大，所以倒着找
                for (int d = 9; d > charArray[i] - '0'; d--) {
                    if (last[d] > i) {
                        swap(charArray, i, last[d]);
                        // 只允许交换一次，因此直接返回
                        return Integer.parseInt(new String(charArray));
                    }
                }
            }
            return num;
        }

        private void swap(char[] charArray, int index1, int index2) {
            char temp = charArray[index1];
            charArray[index1] = charArray[index2];
            charArray[index2] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}