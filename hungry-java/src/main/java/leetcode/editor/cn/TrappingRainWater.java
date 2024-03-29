//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
//
//
//
// 示例 1：
//
//
//
//
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
//
//
// 示例 2：
//
//
//输入：height = [4,2,0,3,2,5]
//输出：9
//
//
//
//
// 提示：
//
//
// n == height.length
// 0 <= n <= 3 * 104
// 0 <= height[i] <= 105
//
// Related Topics 栈 数组 双指针 动态规划
// 👍 2030 👎 0


package leetcode.editor.cn;

public class TrappingRainWater {
    public static void main(String[] args) {
        Solution solution = new TrappingRainWater().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trap(int[] height) {
            int len = height.length;
            if (len == 0) {
                return 0;
            }
            int lMax = height[0];
            int rMax = height[len - 1];
            int l = 0;
            int ans = 0;
            int r = len - 1;
            while (l < r) {
                //核心在于先找大小， 然后找左右大边的小边-那一侧
                lMax = Math.max(height[l], lMax);
                rMax = Math.max(height[r], rMax);
                if (lMax < rMax) {
                    ans += lMax - height[l];
                    l++;
                } else {
                    ans += rMax - height[r];
                    r--;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}