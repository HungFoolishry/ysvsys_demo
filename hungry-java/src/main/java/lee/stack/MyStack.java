package lee.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * description: 队列实现栈
 *
 * @author JunchaoYao
 * @date 2021-01-29 13:36
 **/
class MyStack {
    Deque<Integer> q;
    Integer topInt;
    /** Initialize your data structure here. */
    public MyStack() {
        q = new LinkedList<>();
        topInt = -1;
    }

    /** Push element x onto stack. */
    public void push(int x) {
        q.addLast(x);
        topInt = x;

    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int size = q.size();
        // 留下两个int ，一个做队尾， 一个弹出
        while (size > 2) {
            q.addLast(q.removeFirst());
            size--;
        }
        // 取完队头
        topInt = q.removeFirst();
        // 加至队尾
        q.addLast(topInt);
        return q.removeFirst();

    }

    /** Get the top element. */
    public int top() {
        return topInt;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */