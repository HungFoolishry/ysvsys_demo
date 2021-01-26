package lee.tree;

/**
 * description: BST中搜索
 *
 * @author JunchaoYao
 * @date 2021-01-26 12:43
 **/
public class SearchBST {
    class Solution {
        public TreeNode searchBST(TreeNode root, int val) {
            if (root == null) {
                return null;
            }
            if (root.val == val) {
                return root;
            }
            TreeNode ans;
            if (val > root.val) {
                 ans = searchBST(root.right, val);
            } else {
                 ans = searchBST(root.left, val);
            }
            return ans;

        }
    }
}
