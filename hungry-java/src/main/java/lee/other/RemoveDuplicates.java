package lee.other;

import javax.sound.midi.Soundbank;
import java.util.Arrays;

/**
 * description: 移除重复数字
 *
 * @author JunchaoYao
 * @date 2020-12-16 10:13
 **/
public class RemoveDuplicates {
    static class Solution {
        public static int removeDuplicates(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            int temp = nums[0];
            int insertIndex = 0;
            for (int i=0; i < nums.length; i++) {
                if (temp != nums[i]) {
                    temp = nums[i];
                    insertIndex++;
                    nums[insertIndex] = temp;
                }
            }
            return insertIndex+1;
        }
    }

    public static void main(String[] args) {
        int[] ints = new int[]{1, 1, 2, 3};
        System.out.println(Solution.removeDuplicates(ints));
        System.out.println(Arrays.toString(ints));

    }
//    public int removeDuplicates(int[] nums) {
//        if (nums.length == 0) return 0;
//        int i = 0;
//        for (int j = 1; j < nums.length; j++) {
//            if (nums[j] != nums[i]) {
//                i++;
//                nums[i] = nums[j];
//            }
//        }
//        return i + 1;
//    }

}
