package handwrite;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * description: 自己写的阻塞队列
 *
 * @author JunchaoYao
 * @date 2021-03-25 15:25
 **/
public class YBlockQueue {
    LinkedList<Integer> container = new LinkedList<>();
    AtomicInteger size;
    Lock lock = new ReentrantLock();
    Condition producer = lock.newCondition();
    Condition consumer = lock.newCondition();
    private volatile int capacity;

    public YBlockQueue( int capacity) {
        size = new AtomicInteger(0);
        this.capacity = capacity;
    }

    public int getSize() {
        lock.lock();
        try {
            return size.get();
        }finally {
            lock.unlock();
        }
    }

    public void enqueue(int product) throws InterruptedException {
        lock.lock();
        try {
            while (getSize() == capacity) {
                producer.await();
            }
            container.addFirst(product);
            size.incrementAndGet();
            consumer.signal();
        }finally {
            lock.unlock();
        }
    }

    public int dequeque() throws InterruptedException {
        lock.lock();
        try {
            while (getSize() == 0) {
                consumer.await();
            }
            int ans = container.removeLast();
            size.decrementAndGet();
            producer.signal();
            return ans;
        }finally {
            lock.unlock();
        }

    }

}
