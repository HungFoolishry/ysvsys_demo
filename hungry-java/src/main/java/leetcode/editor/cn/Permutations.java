//给定一个 没有重复 数字的序列，返回其所有可能的全排列。
//
// 示例:
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//]
// Related Topics 回溯算法
// 👍 1171 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
        System.out.println(solution.permute(new int[]{1,2,3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> ans;
        public List<List<Integer>> permute(int[] nums) {
            ans = new ArrayList<>();
            List<Integer> path = new ArrayList<>();
            back(nums, path);
            return ans;
        }

        public void back(int[] nums , List<Integer> path) {
            if (path.size() == nums.length) {
                ans.add(new ArrayList<>(path));
            }
            for (int i = 0; i < nums.length; i++) {
                if (!path.contains(nums[i])) {
                    path.add(nums[i]);
                    back(nums, path);
                    path.remove(path.size()-1);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}