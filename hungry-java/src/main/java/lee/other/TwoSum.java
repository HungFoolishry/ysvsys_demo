package lee.other;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * description: 两数相加
 *
 * @author JunchaoYao
 * @date 2020-12-11 14:11
 **/
public class TwoSum {
    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> intMap = new HashMap<>();
            int index = 0;
            for (int i: nums) {
                if (intMap.containsKey(i) && intMap.get(i) != index) {
                    return new int[]{intMap.get(i), index};
                }
                intMap.put(target - i, index);
                index++;
            }
            return new int[]{};
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.twoSum(new int[]{3, 3}, 6)));
    }
//    class Solution {
//        public int[] twoSum(int[] nums, int target) {
//            Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
//            for (int i = 0; i < nums.length; ++i) {
//                if (hashtable.containsKey(target - nums[i])) {
//                    return new int[]{hashtable.get(target - nums[i]), i};
//                }
//                hashtable.put(nums[i], i);
//            }
//            return new int[0];
//        }
//    }

}
