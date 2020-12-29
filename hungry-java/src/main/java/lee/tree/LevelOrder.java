package lee.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * description: 二叉树层序遍历
 *
 * @author JunchaoYao
 * @date 2020-12-29 19:29
 **/
public class LevelOrder {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) {
                return res;
            }
            Queue<TreeNode> list = new LinkedList<>();
            list.add(root);
            while (!list.isEmpty()) {
                List<Integer> partRes = new ArrayList<>();

                int size = list.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = list.poll();
                    if (node.left != null) {
                        list.add(node.left);
                    }
                    if (node.right != null) {
                        list.add(node.right);
                    }
                    partRes.add(node.val);
                }
                res.add(partRes);
            }
            return res;

        }
    }
}
