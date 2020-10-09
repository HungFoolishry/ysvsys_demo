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
                max = max + num;
            } else {
                max = num;
            }
            ans = Math.max(max, ans);

        }
        return ans;
    }

    public static void main(String[] args) {
        int[] input = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(input));
    }

}
