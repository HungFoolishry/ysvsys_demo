package lee.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * description: 找到等于和的路径
 *
 * @author JunchaoYao
 * @date 2021-01-26 17:09
 **/
public class PathSum {
    class Solution {
        List<List<Integer>> ans = new ArrayList<>();
        Deque<Integer> history = new LinkedList<>();
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            if (root == null) {
                return ans;
            }
            dfs(root, targetSum);
            return ans;
        }

        public void dfs(TreeNode root, int targetSum) {
            if (root == null) {
                return;
            }
            history.addLast(root.val);
            if (root.left == null && root.right == null && root.val == targetSum) {
                List<Integer> endList = new ArrayList<>(history);
                ans.add(endList);
                // 找到后不能返回，后面还有删除操作
            }
            dfs(root.left, targetSum - root.val);
            dfs(root.right, targetSum - root.val);
            history.removeLast();
        }

    }

}
