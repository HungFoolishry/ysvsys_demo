package lee.tree;

/**
 * description: 129. 求根到叶子节点数字之和
 *
 * @author JunchaoYao
 * @date 2020-10-29 20:06
 **/
public class SumNumbers {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        int ans = 0;
        int his = 0;
        public int sumNumbers(TreeNode root) {
            dfs(root);
            return ans;
        }

        public void dfs(TreeNode root) {
            if (root == null) {
                return;
            }
            his = his * 10 + root.val;
            if (root.left == null && root.right == null) {
                ans = ans + his;
            }
            dfs(root.left);
            dfs(root.right);
            his = his / 10;
        }
    }

}
