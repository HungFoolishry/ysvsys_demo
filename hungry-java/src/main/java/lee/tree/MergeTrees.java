package lee.tree;

/**
 * description: 合并二叉树
 *
 * @author JunchaoYao
 * @date 2021-01-26 19:49
 **/
public class MergeTrees {
    class Solution {
        public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
            if (t1 == null && t2 == null) {
                return null;
            }
            if (t1 != null && t2 == null) {
                return t1;
            }
            if (t1 == null&& t2 != null) {
                return t2;
            }
            if (t1 != null && t2 != null) {
                t1.val = t1.val + t2.val;
            }
            t1.left = mergeTrees(t1.left, t2.left);
            t1.right = mergeTrees(t1.right, t2.right);
            return t1;
        }
    }
}
