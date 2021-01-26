package lee.tree;

/**
 * description:二叉搜索树转化为累加树
 *
 * @author JunchaoYao
 * @date 2021-01-26 11:26
 **/
public class ConvertBST {
    class Solution {
        int sum = 0;
        public TreeNode convertBST(TreeNode root) {
            traverse(root);
            return root;

        }

        public void traverse(TreeNode root) {
            if (root == null) {
                return;
            }
            //中序遍历默认升序，如果右边在前，则为降序
            traverse(root.right);
            sum = sum + root.val;
            root.val = sum;
            traverse(root.left);
        }
    }
}
