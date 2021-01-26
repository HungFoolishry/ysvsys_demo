package lee.tree;

/**
 * description: 是否平衡二叉树
 *
 * @author JunchaoYao
 * @date 2021-01-26 19:13
 **/
public class IsBalanced {
    class Solution {
        boolean isBalance = true;
        public boolean isBalanced(TreeNode root) {
            if (!isBalance) {
                return false;
            }
            if (root == null) {
                return true;
            }
            int leftDepth = treeDepths(root.left);

            int rightDepth = treeDepths(root.right);
            if (Math.abs(leftDepth - rightDepth) > 1) {
                isBalance = false;
            }
            return isBalanced(root.left)&& isBalanced(root.right);

        }

        public int treeDepths(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return Math.max(treeDepths(root.left), treeDepths(root.right)) + 1;
        }
    }

}
