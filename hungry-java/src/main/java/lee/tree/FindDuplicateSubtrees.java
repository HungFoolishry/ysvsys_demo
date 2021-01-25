package lee.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * description: 寻找重复子树
 *
 * @author JunchaoYao
 * @date 2021-01-25 20:11
 **/
public class FindDuplicateSubtrees {
    public class TreeNode {
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
        String NULL = "$";
        String SEP = ",";
        HashMap<String,Integer> history = new HashMap();
        List<TreeNode> ans = new ArrayList<>();

        public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
            serialize(root);
            return ans;

        }

        public String serialize(TreeNode root) {
            if (root == null) {
                return NULL;
            }
            String left = serialize(root.left);
            String right = serialize(root.right);
            String s = root.val + SEP + left + SEP + right + SEP;
            if (history.getOrDefault(s, 0) == 0) {
                history.put(s, 1);
            } else if (history.get(s) == 1) {
                history.put(s, 2);
                ans.add(root);
            }
            return s;
        }
    }
}
