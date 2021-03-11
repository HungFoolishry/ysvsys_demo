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

public class FirstMissingPositive {
    public static void main(String[] args) {
        Solution solution = new FirstMissingPositive().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int firstMissingPositive(int[] nums) {
            int len = nums.length;
            for (int i = 0; i < len; i++) {
                //先判断num[i]的范围在 1 -len，nums[3-1] = 3 , 本数值-1 是index 然后index 中的数= 本数值 合法，否则要交换
                while (nums[i] > 0 && nums[i] < len && nums[nums[i] - 1] != nums[i]) {
                    swap(nums, i, nums[i] - 1);
                }

            }
            for (int i = 0; i < len; i++) {
                if (nums[i] != i + 1) {
                    return i + 1;
                }
            }
            return len+1;

        }

        public void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}