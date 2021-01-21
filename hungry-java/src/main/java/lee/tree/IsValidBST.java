package lee.tree;

/**
 * description: 验证二叉搜索树
 *
 * @author JunchaoYao
 * @date 2020-12-28 21:04
 **/
public class IsValidBST {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public boolean isValidBST(TreeNode root) {
            return isValidBST(root, null, null);
        }

        private boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
            if (root == null) {
                return true;
            }
            if (min != null) {
                if ( root.val <= min.val) {
                    return false;
                }
            }
            if (max != null) {
                if ( root.val >= max.val) {
                    return false;
                }
            }
            return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
        }
        }


//    class Solution {
//        long pre = Long.MIN_VALUE;
//        public boolean isValidBST(TreeNode root) {
//            return check(root);
//
//        }
//
//        private boolean check(TreeNode root) {
//            if (root == null) {
//                return true;
//            }
//            if (!check(root.left)) {
//                return false;
//            }
//            if (root.val <= pre) {
//                return false;
//            }
//            pre = root.val;
//            return check(root.right);
//        }
//    }
}
