package lee.tree;

/**
 * description: 插入BST
 *
 * @author JunchaoYao
 * @date 2021-01-26 13:43
 **/
public class InsertIntoBST {
    class Solution {
        public TreeNode insertIntoBST(TreeNode root, int val) {
            if (root == null) {
                // 要返回新节点，而不是null，这样保证空树的时候也可以得到正确答案
                return new TreeNode(val);
            }
            if (val > root.val) {
                root.right = insertIntoBST(root.right, val);
            } else {
                root.left= insertIntoBST(root.left, val);
            }
            return root;

        }
    }
}
