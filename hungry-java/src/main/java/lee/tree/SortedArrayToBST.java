package lee.tree;

/**
 * description: 有序数组转二叉搜索树
 *
 * @author JunchaoYao
 * @date 2020-12-24 15:12
 **/
public class SortedArrayToBST {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            return buildNode(nums, 0, nums.length - 1);
        }

        private TreeNode buildNode(int[] nums, int l, int r) {
            if (l > r) {
                return null;
            }
            int mid = (l + r) / 2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = buildNode(nums, 0, mid-1);
            root.right = buildNode(nums, mid + 1, r);
            return root;
        }
    }
}
