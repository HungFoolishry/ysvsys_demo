package lee.linkedlist;

/**
 * description: 合并两个有序数组
 *
 * @author JunchaoYao
 * @date 2020-12-22 10:23
 **/
public class Merge {
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int i = m - 1;
            int j = n - 1;
            int insert = m + n - 1;
            if (i< 0) {
                System.arraycopy(nums2, 0, nums1, 0, j + 1);
            }
            while (i >= 0 && j >= 0) {
                if (nums1[i] > nums2[j]) {
                    nums1[insert--] = nums1[i--];
                    if (i< 0) {
                        System.arraycopy(nums2, 0, nums1, 0, j + 1);
                        break;
                    }
                } else {
                    nums1[insert--] = nums2[j--];
                }
            }
        }
    }
//    class Solution {
//        public void merge(int[] nums1, int m, int[] nums2, int n) {
//            // two get pointers for nums1 and nums2
//            int p1 = m - 1;
//            int p2 = n - 1;
//            // set pointer for nums1
//            int p = m + n - 1;
//
//            // while there are still elements to compare
//            while ((p1 >= 0) && (p2 >= 0))
//                // compare two elements from nums1 and nums2
//                // and add the largest one in nums1
//            {
//                nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];
//            }
//
//            // add missing elements from nums2
//            System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
//        }
//    }


}
