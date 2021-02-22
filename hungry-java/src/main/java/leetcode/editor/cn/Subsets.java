//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
//
//
// 示例 2：
//
//
//输入：nums = [0]
//输出：[[],[0]]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10
// -10 <= nums[i] <= 10
// nums 中的所有元素 互不相同
//
// Related Topics 位运算 数组 回溯算法
// 👍 995 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        Solution solution = new Subsets().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        public List<List<Integer>> subsets(int[] nums) {
            back(0, nums);
            return ans;

        }
//[[],[1],[1,2],[1,2,3],[1,3],[2],[2,3],[3]]
//  0  1   2     3       3     2    3    3
        //该递归的就是在123 -》23-》3
        public void back(int i, int[] nums) {
            ans.add(new ArrayList<>(tmp));
            for (int j = i; j < nums.length; j++) {
                tmp.add(nums[j]);
                System.out.println("add:"+nums[j]);
                back(j + 1, nums);
                System.out.println("remove:" + tmp.remove(tmp.size() - 1));

            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}