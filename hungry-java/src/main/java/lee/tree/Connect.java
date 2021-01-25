package lee.tree;

/**
 * description: 链接二叉树右边节点
 *
 * @author JunchaoYao
 * @date 2021-01-25 14:52
 **/
public class Connect {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    ;

    class Solution {
        public Node connect(Node root) {
            if (root == null) {
                return null;
            }
            connect(root.left, root.right);
            return root;

        }

        private void connect(Node node1, Node node2) {
            if (node1 == null || node2 == null) {
                return ;
            }
            node1.next = node2;
            connect(node1.left,node1.right);
            connect(node1.left, node2.left);
            connect(node2.left, node2.right);
        }
    }
}