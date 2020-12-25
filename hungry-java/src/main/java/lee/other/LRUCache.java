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
public class LRUCache<K, V> extends LinkedHashMap<K, V> {

//    Map<Integer, Integer> cacheMap = new HashMap<>();
//    LinkedList<Integer> lruList = new LinkedList<Integer>();
//
//    int capacity;
//
//    public LRUCache(int capacity) {
//        this.capacity = capacity;
//    }
//
//    public int get(int key) {
//        int value = cacheMap.getOrDefault(key, -1);
//        if (value == -1) {
//            return value;
//        }
//        lruList.remove(key);
//        lruList.add(0, key);
//        return value;
//    }
//
//
//    public void put(int key, int value) {
//        if (cacheMap.containsKey(key)) {
//            lruList.remove(key);
//            cacheMap.put(key, value);
//            lruList.add(0, value);
//            return;
//        }
//        lruList.add(0, value);
//        if (lruList.size() > this.capacity) {
//            Integer popKey = lruList.removeLast();
//            cacheMap.remove(popKey);
//        }
//        cacheMap.put(key, value);
//    }

    private final int CACHE_SIZE;

    public LRUCache(int cacheSize) {
        super((int) Math.ceil(cacheSize / 0.75) + 1, 0.75f, true);
        CACHE_SIZE = cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > CACHE_SIZE;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);
        cache.put(3, 3);
    }
}