package lee.tree;

import com.sun.org.apache.bcel.internal.generic.INEG;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * description: 236kthSmallest 二叉树最近公共祖先
 *
 * @author JunchaoYao
 * @date 2020-09-29 19:21
 **/


public class PublicAncestor {


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            TreeNode ans = pQinRoot(root, p, q);
            return ans;
        }

        public TreeNode pQinRoot(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) {
                return null;
            }
            // 如果有p或者q则返回该节点，子节点不再遍历
            if (root == p || root == q) {
                return root;

            }
            TreeNode left = pQinRoot(root.left, p, q);
            TreeNode right = pQinRoot(root.right, p, q);
            // p q 存在于左右节点中
            if (left != null && right != null) {
                return root;
            }

            if (left == null && right == null) {
                return null;
            }
            //只有一个 则返回该节点
            return left == null ? right : left;

        }
    }

}

