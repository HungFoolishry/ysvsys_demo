//给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
//
// 示例 1 :
//
//
//输入:nums = [1,1,1], k = 2
//输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
//
//
// 说明 :
//
//
// 数组的长度为 [1, 20,000]。
// 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
//
// Related Topics 数组 哈希表
// 👍 802 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        Solution solution = new SubarraySumEqualsK().new Solution();
        System.out.println(solution.subarraySum(new int[]{1, 2, 3}, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    public class Solution {
        public int subarraySum(int[] nums, int k) {
            int n = nums.length;
            Map<Integer, Integer> sumHis = new HashMap<>();
            int sum = 0;
            int count = 0;
            sumHis.put(0, 1);
            for (int i = 0; i < n; i++) {
                sum += nums[i];
                if (sumHis.containsKey(sum - k)) {
                    count += sumHis.get(sum - k);
                }
                sumHis.put(sum, sumHis.getOrDefault(sum, 0)+1);
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}