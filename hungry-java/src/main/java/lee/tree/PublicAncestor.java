package lee.tree;

/**
 * description: 二叉树最近公共祖先
 *
 * @author JunchaoYao
 * @date 2020-09-29 19:21
 **/


public class PublicAncestor {


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    class Solution {
        TreeNode ans;
        public Solution() {
            this.ans = null;
        }


        public boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) {
                return false;
            }
            if (root.val == p.val || root.val == q.val) {
                return true;
            }
            boolean lson = dfs(root.left, p, q);
            boolean rson = dfs(root.right, p, q);
            if ((lson && rson) || ((root.val == q.val || root.val == p.val) && (lson || rson))) {
                ans = root;
            }
            if (lson || rson || root.val == q.val || root.val == p.val) {
                return true;
            }
            return false;

        }
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            this.dfs(root, p, q);
            return this.ans;
        }
    }


}

