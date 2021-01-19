package lee.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * description: lru
 *
 * @author JunchaoYao
 * @date 2020-10-16 14:12
 **/
class LRUCache {
    Map<Integer, Integer> cacheMap = new HashMap<>();
    LinkedList<Integer> cacheList = new LinkedList<>();
    int capacity;
    final int NOT_SET = -1;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        int val = cacheMap.getOrDefault(key, NOT_SET);
        if (val != NOT_SET) {
            cacheList.remove((Integer) key);
            cacheList.addFirst(key);
        }
        return val;
    }

    public void put(int key, int value) {
        if (!cacheMap.containsKey(key)) {
            cacheList.addFirst(key);
            if (cacheList.size() > capacity) {
                Integer lastKey = cacheList.getLast();
                cacheList.removeLast();
                cacheMap.remove(lastKey);
            }
        } else {
            cacheList.remove((Integer) key);
            cacheList.addFirst(key);
        }
        cacheMap.put(key, value);

    }
}
//
//public class LRUCache {
//    class DLinkedNode {
//        int key;
//        int value;
//        DLinkedNode prev;
//        DLinkedNode next;
//        public DLinkedNode() {}
//        public DLinkedNode(int _key, int _value) {key = _key; value = _value;}
//    }
//
//    private Map<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
//    private int size;
//    private int capacity;
//    private DLinkedNode head, tail;
//
//    public LRUCache(int capacity) {
//        this.size = 0;
//        this.capacity = capacity;
//        // 使用伪头部和伪尾部节点
//        head = new DLinkedNode();
//        tail = new DLinkedNode();
//        head.next = tail;
//        tail.prev = head;
//    }
//
//    public int get(int key) {
//        DLinkedNode node = cache.get(key);
//        if (node == null) {
//            return -1;
//        }
//        // 如果 key 存在，先通过哈希表定位，再移到头部
//        moveToHead(node);
//        return node.value;
//    }
//
//    public void put(int key, int value) {
//        DLinkedNode node = cache.get(key);
//        if (node == null) {
//            // 如果 key 不存在，创建一个新的节点
//            DLinkedNode newNode = new DLinkedNode(key, value);
//            // 添加进哈希表
//            cache.put(key, newNode);
//            // 添加至双向链表的头部
//            addToHead(newNode);
//            ++size;
//            if (size > capacity) {
//                // 如果超出容量，删除双向链表的尾部节点
//                DLinkedNode tail = removeTail();
//                // 删除哈希表中对应的项
//                cache.remove(tail.key);
//                --size;
//            }
//        }
//        else {
//            // 如果 key 存在，先通过哈希表定位，再修改 value，并移到头部
//            node.value = value;
//            moveToHead(node);
//        }
//    }
//
//    private void addToHead(DLinkedNode node) {
//        node.prev = head;
//        node.next = head.next;
//        head.next.prev = node;
//        head.next = node;
//    }
//
//    private void removeNode(DLinkedNode node) {
//        node.prev.next = node.next;
//        node.next.prev = node.prev;
//    }
//
//    private void moveToHead(DLinkedNode node) {
//        removeNode(node);
//        addToHead(node);
//    }
//
//    private DLinkedNode removeTail() {
//        DLinkedNode res = tail.prev;
//        removeNode(res);
//        return res;
//    }
//}
