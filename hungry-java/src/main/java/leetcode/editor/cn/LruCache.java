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
// 👍 1148 👎 0


package leetcode.editor.cn;

import com.sun.tools.internal.ws.wsdl.document.soap.SOAPUse;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LruCache {
    //leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache {
        LruList list;
        Map<Integer, Node> map;
        int capacity;

        public LRUCache(int capacity) {
            list = new LruList();
            map = new HashMap<>();
            this.capacity = capacity;
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            Node node = map.get(key);
            list.del(node);
            list.addRecent(node);
            return node.val;
        }

        public void put(int key, int value) {
            Node node = new Node(key, value);
            if (map.containsKey(key)) {
                list.del(map.get(key));
            }
            map.put(key, node);
            list.addRecent(node);
            if (list.getSize() > capacity) {
                Node last = list.removeLast();
                map.remove(last.key);
            }

        }

        class Node {
            Integer key;
            Integer val;
            Node next;
            Node pre;

            public Node(Integer key, Integer val) {
                this.key = key;
                this.val = val;
            }
        }

        class LruList {
            Node head;
            Node tail;
            int size;

            LruList() {
                head = new Node(null, null);
                tail = new Node(null, null);;
                head.next = tail;
                tail.pre = head;
            }

            public int getSize() {
                return size;
            }

            public void del(Node node) {
                //易错点 前后要看清
                node.pre.next = node.next;
                node.next.pre = node.pre;
                node.next = null;
                size--;

            }

            public void addRecent(Node node) {
                Node tmp = head.next;
                head.next = node;
                node.next = tmp;
                node.pre = head;
                tmp.pre = node;
                size++;

            }

            public Node removeLast() {
                Node tmp = tail.pre;
                del(tmp);
                return tmp;
            }
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