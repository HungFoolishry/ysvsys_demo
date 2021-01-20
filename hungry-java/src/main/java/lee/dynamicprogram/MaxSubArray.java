package lee.dynamicprogram;

/**
 * description: 最大子序和
 *
 * @author JunchaoYao
 * @date 2020-08-14 15:58
 **/
public class MaxSubArray {
    public static int maxSubArray(int[] nums) {
        int ans = nums[0];
        int max = 0;
        for(int num: nums){
            if (max > 0) {
                // 之前的和对本次加法是正效果的就可以留着，不然就留着本数字就行了
                max = max + num;
            } else {
                max = num;
            }
            // 历史中最大的数字记录
            ans = Math.max(max, ans);

        }
        return ans;
    }

    public static void main(String[] args) {
        int[] input = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(input));
    }
//    class Solution {
//        public int maxSubArray(int[] nums) {
//            int pre = 0, maxAns = nums[0];
//            for (int x : nums) {
//                pre = Math.max(pre + x, x);
//                maxAns = Math.max(maxAns, pre);
//            }
//            return maxAns;
//        }
//    }


}
