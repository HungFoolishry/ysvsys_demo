package lee.search;

/**
 * description: 旋转搜索
 *
 * @author JunchaoYao
 * @date 2021-02-05 15:03
 **/
public class SpinSearch {
    static class Solution {
        //核心在于用nums[0]与mid比较找到连续的区间，target 不在连续区间内，就在另外一个区间
        public int search(int[] nums, int target) {
            int len = nums.length;
            int l = 0;
            int r = len - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (target == nums[mid]) {
                    return mid;
                }
                if (nums[0] > nums[mid]) {
                    if (target > nums[mid] && target <= nums[r]) {
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                } else {
                    if (target >= nums[l] && target < nums[mid]) {
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                }
            }

            return -1;
        }
    }
    public static void main(String[] args) {
        Solution spinSearch = new Solution();
        System.out.println(spinSearch.search(new int[]{ 4,5,6,7,8,1,2,3}, 2));
    }
}
