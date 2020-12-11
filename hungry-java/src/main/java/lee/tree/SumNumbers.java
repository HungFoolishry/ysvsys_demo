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
        int result;
        public Solution(){
            result = 0;
        }

        private void sumNode(TreeNode node, int sum) {
            if (node == null) {
               return;
            }
            if (node.left == null && node.right == null) {
                sum = sum * 10 + node.val;
                this.result = this.result + sum;
            }
            sum = sum * 10 + node.val;
            if (node.left != null) {
                sumNode(node.left, sum);
            }
            if (node.right != null) {
                sumNode(node.right, sum);
            }

        }

        public int sumNumbers(TreeNode root) {
            this.sumNode(root, 0);
            return this.result;
        }
    }

}
