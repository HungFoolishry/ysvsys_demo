package lee.dynamicprogram;

/**
 * description: 乘积最大子数组
 *[2,3,-2,4]
 * @author JunchaoYao
 * @date 2021-01-20 13:37
 **/
public class MaxProduct {
    //以i结尾的一个？-i区间最大值 = max ( min*n[i] , max*n[i], 在min>0&&max>0&&n[i]<0:n[i])
    class Solution {
        public int maxProduct(int[] nums) {
            int length = nums.length;
            int[] maxF = new int[length];
            int[] minF = new int[length];
            System.arraycopy(nums, 0, maxF, 0, length);
            System.arraycopy(nums, 0, minF, 0, length);
            for (int i = 1; i < length; ++i) {
                maxF[i] = Math.max(maxF[i - 1] * nums[i], Math.max(nums[i], minF[i - 1] * nums[i]));
                minF[i] = Math.min(minF[i - 1] * nums[i], Math.min(nums[i], maxF[i - 1] * nums[i]));
            }
            int ans = maxF[0];
            for (int i = 1; i < length; ++i) {
                ans = Math.max(ans, maxF[i]);
            }
            return ans;
        }
    }


/*    class Solution {
        public int maxProduct(int[] nums) {
            int max = Integer.MIN_VALUE, imax = 1, imin = 1;
            for(int i=0; i<nums.length; i++){
                if(nums[i] < 0){
                    int tmp = imax;
                    imax = imin;
                    imin = tmp;
                }
                //重新计算起点 imax区间最大 imin 区间最小
                imax = Math.max(imax*nums[i], nums[i]);
                imin = Math.min(imin*nums[i], nums[i]);

                max = Math.max(max, imax);
            }
            return max;
        }
    }*/

}
