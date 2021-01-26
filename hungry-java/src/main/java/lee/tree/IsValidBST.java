package lee.tree;

/**
 * description: 验证二叉搜索树
 *
 * @author JunchaoYao
 * @date 2020-12-28 21:04
 **/
public class IsValidBST {

    class Solution {
        Long min = Long.MAX_VALUE;
        public boolean isValidBST(TreeNode root) {
            if (root == null) {
                return true;
            }
            // BST中序先右节点是倒序
            boolean right = isValidBST(root.right);
            if (root.val >= min) {
                return false;
            }
            min = (long)root.val;
            boolean left=isValidBST(root.left);
            return right && left;

        }

        }

}
