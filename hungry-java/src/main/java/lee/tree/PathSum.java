package lee.tree;

import java.util.ArrayList;
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
        List<Integer> history = new ArrayList<>();
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            if (root == null) {
                return ans;
            }
            history.add(root.val);
            dfs(root, targetSum);
            return ans;
        }

        public void dfs(TreeNode root, int targetSum) {
            if (root == null) {
                return ;
            }
            if (root.left == null && root.right == null && root.val == targetSum) {
                List<Integer> endList = new ArrayList<>(history);
                ans.add(endList);
                return;
            }
            if (root.left != null) {
                history.add(root.left.val);
            }
            dfs(root.left, targetSum - root.val);
            if (root.left != null) {
                history.remove(history.size() - 1);
            }
            if (root.right != null) {
                history.add(root.right.val);
            }
            dfs(root.right, targetSum - root.val);
            if (root.right != null) {
                history.remove(history.size() - 1);
            }
        }
    }

}
