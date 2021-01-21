package lee.other;

import java.util.HashMap;
import java.util.Map;

/**
 * description: lru
 *
 * @author JunchaoYao
 * @date 2020-10-16 14:12
 **/
public class LRUCache {
    private Map<Integer, Node> map;
    //队列头是要被淘汰的
    private DoubleList doubleList;
    int capacity;

   public LRUCache(int capacity) {
        this.capacity = capacity;
        doubleList = new DoubleList();
        map = new HashMap<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        doubleList.remove(node);
        doubleList.addLast(node);
        return map.get(key).val;
    }

    public void put(int key, int value) {
        Node node = new Node(key, value);
        if (map.containsKey(key)) {
            doubleList.remove(node);
            doubleList.addLast(node);
        }else {
            doubleList.addLast(node);
        }
        map.put(key, node);

        if (doubleList.size > capacity) {
            Node firstNode = doubleList.removeFirst();
            map.remove(firstNode.key);
        }

    }
    private void makeRecently(int key) {
        // key 已经存在 要提升到队列尾部
        Node node = map.get(key);
        doubleList.remove(node);
        doubleList.addLast(node);
    }

    private void addRecently(int key, int val) {
        // key 不在map里面 要增加key
        Node node = new Node(key, val);
        map.put(key, node);
        doubleList.addLast(node);
    }

    private void delKey(int key) {
        doubleList.remove(map.get(key));
        map.remove(key);
    }

    private void removeOld() {
        Node node = doubleList.removeFirst();
        map.remove(node.key);

    }

    class Node {
        public int key,val;
        public Node pre, next;
        public Node(int k, int v){
            this.key = k;
            this.val = v;

        }
    }
    class DoubleList {
        private final Node head;
        private final Node tail;
        private int size;
        public DoubleList() {
            //两个虚拟节点
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.pre = head;
            size = 0;
        }

        public void addLast(Node node) {
            node.pre = tail.pre;
            node.next = tail;
            tail.pre.next = node;
            tail.pre = node;
            size++;
        }

        public void remove(Node node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
            size--;
        }

        public Node removeFirst() {
            //需要返回节点来处理map中的node
            if (head.next == tail) {
                return null;
            }
            Node first = head.next;
            // 在remove中已经--
            remove(first);
            return first;
        }

    }

}
