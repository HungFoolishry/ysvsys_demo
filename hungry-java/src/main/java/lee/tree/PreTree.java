package lee.tree;

/**
 * description: 二叉树前序遍历
 *
 * @author JunchaoYao
 * @date 2020-09-30 14:45
 **/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PreTree {

    List<Integer> result;
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        List<Integer> result;

        public Solution() {
            result = new ArrayList<>();

        }

        public void dfs(TreeNode root) {
            if (root == null) {
                return;
            }
            this.result.add(root.val);
            dfs(root.left);
            dfs(root.right);
        }
        public List<Integer> preorderTraversal(TreeNode root) {
            this.dfs(root);
            return this.result;

        }
    }
}