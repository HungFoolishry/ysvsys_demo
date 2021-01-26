package lee.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * description: 全排列
 *for 选择 in 选择列表:
 *     # 做选择
 *     将该选择从选择列表移除
 *     路径.add(选择)
 *     backtrack(路径, 选择列表)
 *     # 撤销选择
 *     路径.remove(选择)
 *     将该选择再加入选择列表
 * @author JunchaoYao
 * @date 2021-01-26 20:21
 **/
public class Permute {
    class Solution {
        List<List<Integer>> ans = new ArrayList<>();
        public List<List<Integer>> permute(int[] nums) {
            LinkedList<Integer> trace = new LinkedList<>();
            backtrack(nums, trace);
            return ans;
        }

        public void backtrack(int[] nums, LinkedList<Integer> trace) {
            //base case
            if (trace.size() == nums.length) {
                ans.add(new ArrayList<>(trace));
                return;
            }

            for (int num : nums) {
                if (trace.contains(num)) {
                    continue;
                }
                trace.add(num);
                backtrack(nums, trace);
                // 为了for循环中下一个迭代数字
                trace.removeLast();
            }

        }
    }
}
