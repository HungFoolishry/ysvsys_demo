//给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
//
//
//
// 进阶：你可以实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案吗？
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,0]
//输出：3
//
//
// 示例 2：
//
//
//输入：nums = [3,4,-1,1]
//输出：2
//
//
// 示例 3：
//
//
//输入：nums = [7,8,9,11,12]
//输出：1
//
//
//
//
// 提示：
//
//
// 0 <= nums.length <= 300
// -231 <= nums[i] <= 231 - 1
//
// Related Topics 数组
// 👍 980 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

public class FirstMissingPositive {
    public static void main(String[] args) {
        Solution solution = new FirstMissingPositive().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int firstMissingPositive(int[] nums) {
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                while (nums[i] >0 && nums[i] < n && nums[nums[i] - 1] != nums[i]) {
                    swap(nums, nums[i] - 1, i);
                }
            }
            for (int i = 0; i < n; i++) {
                if (i + 1 != nums[i]) {
                    return i + 1;
                }
            }
            return n + 1;

        }

        public void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            System.out.println(Arrays.toString(nums));
        }
    }
    // [-1,4,2,1,9,10]
    // [-1, 1, 2, 4, 9, 10]
    // [1, -1, 2, 4, 9, 10]
    // [1, 2, -1, 4, 9, 10]
//leetcode submit region end(Prohibit modification and deletion)

}