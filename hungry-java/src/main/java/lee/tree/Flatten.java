package lee.tree;

/**
 * description: 二叉树展开为链表
 *
 * @author JunchaoYao
 * @date 2021-01-25 00:15
 **/
public class Flatten {

    class Solution {
        public void flatten(TreeNode root) {
            if (root == null) {
                return;
            }
            flatten(root.left);
            flatten(root.right);
            TreeNode left = root.left;
            TreeNode right = root.right;
            root.left = null;
            root.right = left;
            TreeNode cur = root;
            while (cur.right != null) {
                cur = cur.right;

            }
            cur.right = right;

        }
    }
}
