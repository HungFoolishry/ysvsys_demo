package lee.other;

/**
 * description: 接雨水
 *
 * @author JunchaoYao
 * @date 2021-02-04 10:48
 **/
public class Trap {
    static class Solution {
        public int trap(int[] height) {
            int ans = 0;
            int left = 0;
            int right = height.length - 1;
            int lMax = height[left];
            int rMax = height[right];
            while (left < right) {
                lMax = Math.max(lMax, height[left]);
                rMax = Math.max(rMax, height[right]);
                if (lMax < rMax) {
                    ans += lMax - height[left];
                    left++;
                }else {
                    ans += rMax - height[right];
                    right--;
                }

            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2,}));
    }
}
