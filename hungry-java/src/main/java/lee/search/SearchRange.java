package lee.search;

/**
 * description: 查找目标的范围下标
 *
 * @author JunchaoYao
 * @date 2021-01-22 18:48
 **/
public class SearchRange {
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            int mid2 = -1;
            int[] ans = new int[2];
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    right = mid - 1;
                    mid2 = mid2 == -1 ? mid : mid2;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                }
            }
            if (left >= nums.length || nums[left] != target) {
                return new int[]{-1, -1};
            }
            ans[0] = left;
            left = mid2;
            right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                }
            }
            ans[1] = right;
            return ans;

        }
    }

}
