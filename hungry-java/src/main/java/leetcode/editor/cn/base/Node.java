package leetcode.editor.cn.base;

/**
 * description:
 *
 * @author JunchaoYao
 * @date 2021-03-11 17:40
 **/
public class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
