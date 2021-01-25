package lee.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * description: 是否对称二叉树
 *
 * @author JunchaoYao
 * @date 2020-12-24 10:23
 **/
public class IsSymmetric {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        public boolean isSymmetric(TreeNode root) {
            return check(root, root);
        }

        public boolean check(TreeNode left, TreeNode right) {
            if (left == null &&  right == null) {
                return true;

            }
            if (left == null || right == null) {
                return false;
            }
            if (left.val == right.val) {
                return check(right.left, left.right) && check(left.left, right.right);
            }
            return false;
        }

   }

}
