package lee.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * description: 二叉树序列化与反序列化
 *
 * @author JunchaoYao
 * @date 2021-01-25 19:20
 **/
public class Serialize {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public class Codec {

        String SEP = ",";
        String NULL = "$";
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            serialize(root, sb);
            return sb.toString();

        }

        public void serialize(TreeNode root, StringBuilder sb) {
            if (root == null) {
                sb.append(NULL).append(SEP);
                return;
            }
            sb.append(root.val).append(SEP);
            serialize(root.left, sb);
            serialize(root.right, sb);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] list = data.split(SEP);
            LinkedList<String> linkedList = new LinkedList<>();
            for (String s : list) {
                linkedList.addLast(s);
            }
            return deserialize(linkedList);
        }

        public TreeNode deserialize(LinkedList<String> linkedList) {
            if (linkedList.isEmpty()) {
                return null;
            }
            if (linkedList.getFirst().equals(NULL)) {
                linkedList.removeFirst();
                return null;
            }
            TreeNode root = new TreeNode(Integer.parseInt(linkedList.removeFirst()));
            root.left = deserialize(linkedList);
            root.right = deserialize(linkedList);
            return root;
        }
    }

}
