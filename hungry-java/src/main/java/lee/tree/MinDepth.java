package lee.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * description: 二叉树最小深度
 *
 * @author JunchaoYao
 * @date 2021-01-27 11:08
 **/
public class MinDepth {
    class Solution {
        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            Deque<TreeNode> nodes = new LinkedList<>();
            nodes.offer(root);
            int depth = 1;
            while (!nodes.isEmpty()) {
                int size = nodes.size();
                for (int i = 0; i < size; i++) {
                    TreeNode cur = nodes.poll();
                    if (cur.left == null && cur.right == null) {
                        return depth;
                    }
                    if (cur.left != null) {
                        nodes.offer(cur.left);
                    }
                    if (cur.right != null) {
                        nodes.offer(cur.right);
                    }
                }
                depth++;
            }
            return depth;
        }
    }

//    class Solution {
//        public int minDepth(TreeNode root) {
//            if (root == null) {
//                return 0;
//            }
//            return dfs(root);
//
//
//        }
//
//        public int dfs(TreeNode root) {
//            if (root == null) {
//                return Integer.MAX_VALUE-1;
//            }
//            if (root.left == null && root.right == null) {
//                return 1;
//            }
//            return Math.min(dfs(root.left), dfs(root.right)) + 1;
//        }
//    }
}
