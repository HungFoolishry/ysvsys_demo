package lee.tree;

/**
 * description: 是否有根到叶的路径和等于target
 *
 * @author JunchaoYao
 * @date 2021-01-26 17:01
 **/
public class HasPathSum {
    class Solution {
        public boolean hasPathSum(TreeNode root, int targetSum) {
            if (root == null) {
                return false;
            }
            if (root.left == null && root.right == null) {
                return root.val == targetSum;
            }
            boolean left = hasPathSum(root.left, targetSum - root.val);
            boolean right = hasPathSum(root.right, targetSum - root.val);
            return left || right;

        }
    }
}
