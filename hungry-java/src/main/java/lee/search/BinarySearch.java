package lee.search;

/**
 * description: 二分查找 正常版本，左边界，右边界
 *
 * @author JunchaoYao
 * @date 2021-01-22 15:16
 **/
public class BinarySearch {
    public int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        // 因为搜索区间是[left, right],极限情况 left = right的时候 还是要搜索的
        while (left <= right) {
            // 防止溢出
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
                //数字在mid的左边
            } else if (nums[mid]>target) {
                right = mid - 1;
                //在mid的右边
            } else if (nums[mid]<target) {
                left = mid + 1;
            }
        }
        return -1;
    }

    public int leftBinarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 别返回，锁定左侧边界
                right = mid - 1;
            }
        }
        // 最后要检查 left 越界的情况 在所有数值<target, left= length+1 / 在所有数值>target,left = right = 0
        // 在right 没有移动的情况下，left=len-1 +1，溢出了数组的下标
        if (left >= nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }

    public int rightBinarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 别返回，锁定右侧边界
                left = mid + 1;
            }
        }
        // 最后要检查 right 越界的情况, 在所有数值< target, left=right = len-1/all >target, right=left-1=-1
        // 因为是右边界，所以返回right。在left没有移动的情况下，跳出循环的时候right = left-1 = -1，会溢出，所以必须判断
        if (right < 0 || nums[right] != target)
            return -1;
        return right;
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.rightBinarySearch(new int[]{1, 2, 2, 2, 3,}, 10));
    }

}
