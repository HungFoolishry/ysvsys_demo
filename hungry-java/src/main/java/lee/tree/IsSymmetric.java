package lee.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * description: 是否对称二叉树
 *
 * @author JunchaoYao
 * @date 2020-12-24 10:23
 **/
public class IsSymmetric {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        public boolean isSymmetric(TreeNode root) {
            return check(root, root);

        }

        private boolean check(TreeNode p, TreeNode q) {
            if (p == null && q == null) {
                return true;
            }
            if (p == null || q == null) {
                return false;
            }
            if (p.val == q.val) {
                return check(p.left, q.right) && check(p.right, q.left);
            }
            return false;
        }
    }
//    class Solution {
//        public boolean isSymmetric(TreeNode root) {
//            return check(root, root);
//        }
//
//        public boolean check(TreeNode u, TreeNode v) {
//            Queue<TreeNode> q = new LinkedList<TreeNode>();
//            q.offer(u);
//            q.offer(v);
//            while (!q.isEmpty()) {
//                u = q.poll();
//                v = q.poll();
//                if (u == null && v == null) {
//                    continue;
//                }
//                if ((u == null || v == null) || (u.val != v.val)) {
//                    return false;
//                }
//
//                q.offer(u.left);
//                q.offer(v.right);
//
//                q.offer(u.right);
//                q.offer(v.left);
//            }
//            return true;
//        }
//    }

}
