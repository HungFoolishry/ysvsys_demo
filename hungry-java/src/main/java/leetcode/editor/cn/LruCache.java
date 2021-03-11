//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制 。
//
//
//
// 实现 LRUCache 类：
//
//
// LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
// void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上
//限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
//
//
//
//
//
//
// 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？
//
//
//
// 示例：
//
//
//输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
//
//
//
//
// 提示：
//
//
// 1 <= capacity <= 3000
// 0 <= key <= 3000
// 0 <= value <= 104
// 最多调用 3 * 104 次 get 和 put
//
// Related Topics 设计
// 👍 1209 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class LruCache {

    //leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache {
        private Map<Integer, Node> map;
        private DList dList;
        public Integer capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            dList = new DList();
            map = new HashMap<>();

        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            Node node = map.get(key);
            dList.removeNode(node);
            dList.addNode(node);
            return node.val;
        }

        public void put(int key, int value) {
            Node newNode = new Node(key, value);
            if (map.containsKey(key)) {
                Node node = map.get(key);
                dList.removeNode(node);
                map.put(key, newNode);
                dList.addNode(newNode);
            } else {
                map.put(key, newNode);
                dList.addNode(newNode);
                if (capacity < dList.size) {
                    Node removeNode = dList.removeOldest();
                    map.remove(removeNode.key);
                }
            }
        }
    }

    class Node {
        public Node pre;
        public Node next;
        public Integer key;
        public Integer val;

        public Node(Integer key, Integer val) {
            this.key = key;
            this.val = val;
        }
    }

    class DList {
        public Node head;
        public Node tail;
        public int size;

        DList() {
            head = new Node(null,null);
            tail = new Node(null,null);
            head.next = tail;
            tail.pre = head;
            size = 0;
        }

        public Node removeOldest() {
            Node node = head.next;
            removeNode(node);
            return node;

        }

        public void removeNode(Node node) {
            Node tmp = node.next;
            node.pre.next = tmp;
            tmp.pre = node.pre;
            node.next = null;
            node.pre = null;
            size--;
        }

        public void addNode(Node node) {
            Node tmp = tail.pre;
            tmp.next = node;
            node.next = tail;
            tail.pre = node;
            node.pre = tmp;
            size++;
        }

    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}