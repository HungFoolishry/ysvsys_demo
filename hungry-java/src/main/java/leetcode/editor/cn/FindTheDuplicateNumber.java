//给定一个包含 n + 1 个整数的数组 nums ，
// 其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。
//
// 假设 nums 只有 一个重复的整数 ，找出 这个重复的数 。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,3,4,2,2]
//输出：2
//
//
// 示例 2：
//
//
//输入：nums = [3,1,3,4,2]
//输出：3
//
//
// 示例 3：
//
//
//输入：nums = [1,1]
//输出：1
//
//
// 示例 4：
//
//
//输入：nums = [1,1,2]
//输出：1
//
//
//
//
// 提示：
//
//
// 2 <= n <= 3 * 104
// nums.length == n + 1
// 1 <= nums[i] <= n
// nums 中 只有一个整数 出现 两次或多次 ，其余整数均只出现 一次
//
//
//
//
// 进阶：
//
//
// 如何证明 nums 中至少存在一个重复的数字?
// 你可以在不修改数组 nums 的情况下解决这个问题吗？
// 你可以只用常量级 O(1) 的额外空间解决这个问题吗？
// 你可以设计一个时间复杂度小于 O(n2) 的解决方案吗？
//
// Related Topics 数组 双指针 二分查找
// 👍 1123 👎 0


package leetcode.editor.cn;

public class FindTheDuplicateNumber {
    public static void main(String[] args) {
        Solution solution = new FindTheDuplicateNumber().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    public class Solution {

        public int findDuplicate(int[] nums) {
            int len = nums.length;
            int left = 1;
            int right = len - 1;
            while (left < right) {
                // 在 Java 里可以这么用，当 left + right 溢出的时候，无符号右移保证结果依然正确
                int mid = (left + right) >>> 1;

                int cnt = 0;
                for (int num : nums) {
                    if (num <= mid) {
                        cnt += 1;
                    }
                }

                // 根据抽屉原理，小于等于 4 的个数如果严格大于 4 个
                // 此时重复元素一定出现在 [1, 4] 区间里
                if (cnt > mid) {
                    // 重复元素位于区间 [left, mid]
                    right = mid;
                } else {
                    // if 分析正确了以后，else 搜索的区间就是 if 的反面
                    // [mid + 1, right]
                    left = mid + 1;
                }
            }
            return left;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}