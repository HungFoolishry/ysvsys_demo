//给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
//
// 两棵树重复是指它们具有相同的结构以及相同的结点值。
//
// 示例 1：
//
//         1
//       / \
//      2   3
//     /   / \
//    4   2   4
//       /
//      4
//
//
// 下面是两个重复的子树：
//
//       2
//     /
//    4
//
//
// 和
//
//     4
//
//
// 因此，你需要以列表的形式返回上述重复子树的根结点。
// Related Topics 树
// 👍 250 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.base.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindDuplicateSubtrees{
    public static void main(String[] args) {
         Solution solution = new FindDuplicateSubtrees().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
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
//leetcode submit region end(Prohibit modification and deletion)

}