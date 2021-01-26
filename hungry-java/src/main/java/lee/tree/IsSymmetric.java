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
        boolean isSymmetric = true;
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }
            dfs(root.left, root.right);
            return isSymmetric;
        }

        public void dfs(TreeNode node1, TreeNode node2) {
            if (!isSymmetric) {
                return;
            }
            if (node1 == null && node2 == null) {
                return;
            }
            if (node1 == null || node2 == null) {
                isSymmetric = false;
                return;
            }
            if (node1.val != node2.val) {
                isSymmetric = false;
                return;
            }
            dfs(node1.left, node2.right);
            dfs(node1.right, node2.left);
        }
    }


}
