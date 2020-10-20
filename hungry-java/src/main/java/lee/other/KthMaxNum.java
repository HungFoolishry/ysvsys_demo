package lee.other;

import java.util.Arrays;
import java.util.Random;

/**
 * description: 第k个大元素
 *
 * @author JunchaoYao
 * @date 2020-10-19 15:12
 **/
public class KthMaxNum {
    static class Solution {
        Random random = new Random();
        public int findKthLargest(int[] nums, int k) {
            return  quickSortMain(nums, k);

        }

        public void swap(int[] nums, int a, int b) {
            int tmp = nums[a];
            nums[a] = nums[b];
            nums[b] = tmp;
        }

        public int partition(int[] nums, int l, int r) {
            int piv = random.nextInt(r - l + 1) + l;
            int pivValue = nums[piv];
            swap(nums,r, piv);
            int tmpIndex = l;
            for (int i=l; i< r; ++i) {
                if (nums[i]<= pivValue) {
                    swap(nums,i, tmpIndex);
                    tmpIndex++;
                }
            }
            swap(nums,tmpIndex,r);
            return tmpIndex;
        }
        public void quickSort(int[] nums, int l, int r, int k) {
            if (l >= r) {
                return;
            }
            int piv = partition(nums, l, r);
            if (piv == (nums.length - k)) {
                return;
            }
            if (piv < (nums.length - k)) {
                quickSort(nums, piv + 1, r, k);
            } else {
                quickSort(nums, l, piv-1, k);
            }
        }
        public int quickSortMain(int[] nums, int k) {
            quickSort(nums, 0, nums.length - 1, k);
            return nums[nums.length - k];

        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = {3,2,1,5,6,4};
        System.out.println(solution.quickSortMain(ints, 2));
    }
//    class Solution {
//        Random random = new Random();
//
//        public int findKthLargest(int[] nums, int k) {
//            return quickSelect(nums, 0, nums.length - 1, nums.length - k);
//        }
//
//        public int quickSelect(int[] a, int l, int r, int index) {
//            int q = randomPartition(a, l, r);
//            if (q == index) {
//                return a[q];
//            } else {
//                return q < index ? quickSelect(a, q + 1, r, index) : quickSelect(a, l, q - 1, index);
//            }
//        }
//
//        public int randomPartition(int[] a, int l, int r) {
//            int i = random.nextInt(r - l + 1) + l;
//            swap(a, i, r);
//            return partition(a, l, r);
//        }
//
//        public int partition(int[] a, int l, int r) {
//            int x = a[r], i = l - 1;
//            for (int j = l; j < r; ++j) {
//                if (a[j] <= x) {
//                    swap(a, ++i, j);
//                }
//            }
//            swap(a, i + 1, r);
//            return i + 1;
//        }
//
//        public void swap(int[] a, int i, int j) {
//            int temp = a[i];
//            a[i] = a[j];
//            a[j] = temp;
//        }
//    }

}
