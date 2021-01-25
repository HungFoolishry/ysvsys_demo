package lee.tree;

import java.util.Arrays;

/**
 * description: 构建最大二叉树
 *
 * @author JunchaoYao
 * @date 2021-01-25 15:16
 **/
public class ConstructMaximumBinaryTree {
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
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            return constructMaximumBinaryTree(nums, 0, nums.length - 1);
        }

        private TreeNode constructMaximumBinaryTree(int[] nums, int start, int end) {
            if (end < start) {
                return null;
            }
            int i = getMaxIndex(nums, start, end);
            TreeNode root = new TreeNode(nums[i]);
            root.left = constructMaximumBinaryTree(nums, start, i - 1);
            root.right = constructMaximumBinaryTree(nums, i+1, end);
            return root;
        }
        private int getMaxIndex(int[] nums,  int start, int end) {
            int index = -1;
            int max = Integer.MIN_VALUE;
            for (int i = start; i <=end; i++) {
                if (nums[i] > max) {
                    index = i;
                    max = nums[i];
                }
            }
            return index;
        }
    }

//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        System.out.println(solution.constructMaximumBinaryTree(new int[]{3,2,1,6,0,5}));
//    }
}
