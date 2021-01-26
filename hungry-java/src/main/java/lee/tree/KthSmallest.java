package lee.tree;

/**
 * description: 230 二叉搜索树中k小的元素
 *
 * @author JunchaoYao
 * @date 2021-01-26 10:41
 **/
public class KthSmallest {

    class Solution {
        Integer ans = null;
        Integer rank = 0;
        public int kthSmallest(TreeNode root, int k) {
            traverse(root, k);
            return ans;
        }

        public void traverse(TreeNode root, int k) {
            if (root == null) {
                return;
            }
            traverse(root.left, k);
            //BST中序遍历就是升序遍历
            rank++;
            if (rank == k) {
                ans = root.val;
            }
            traverse(root.right, k);
        }
    }
}
