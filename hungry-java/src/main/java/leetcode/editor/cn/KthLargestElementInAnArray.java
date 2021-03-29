//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
//
// 示例 1:
//
// 输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
//
//
// 示例 2:
//
// 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4
//
// 说明:
//
// 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
// Related Topics 堆 分治算法
// 👍 914 👎 0


package leetcode.editor.cn;

public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new KthLargestElementInAnArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            qSort(nums, 0, nums.length-1, k);
            return nums[nums.length - k];
        }

        public void qSort(int[] nums, int l, int r, int k) {
            if (l >= r) {
                return;
            }
            int mid = partition(nums, l, r);
            if (mid == nums.length - k) {
                return;
            } else if (mid < nums.length - k) {
                qSort(nums, mid + 1, r, k);
            } else {
                qSort(nums, l, mid - 1, k);
            }
        }

        public int partition(int[] nums, int l, int r) {
            int intR = nums[r];
            int smallIndex = l;
            for (int i = l; i < r; i++) {
                if (nums[i] < intR) {
                    swap(nums, i, smallIndex);
                    smallIndex++;
                }
            }
            swap(nums, smallIndex, r);
            return smallIndex;
        }

        public void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}