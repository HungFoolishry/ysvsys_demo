package lee.stack;

import java.util.LinkedList;
import java.util.Stack;

/**
 * description: 两个栈实现队列
 *
 * @author JunchaoYao
 * @date 2021-01-29 13:39
 **/
class CQueue {
    private Stack<Integer> s1, s2;

    public CQueue() {
        // 队尾栈
        s1 = new Stack<>();
        // 队头栈
        s2 = new Stack<>();
    }

    public void appendTail(int value) {
        s1.push(value);
    }

    public int deleteHead() {
        if (s2.isEmpty() && s1.isEmpty()) {
            return -1;
        }
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }

}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */


