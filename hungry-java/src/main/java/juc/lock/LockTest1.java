package juc.lock;

/**
 * description:
 *
 * @author JunchaoYao
 * @date 2020-07-14 15:18
 **/
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// LockTest1.java
// 仓库
class Test1Depot {
    private int size;        // 仓库的实际数量
    private Lock lock;        // 独占锁

    public Test1Depot() {
        this.size = 0;
        this.lock = new ReentrantLock();
    }

    public void produce(int val) {
        lock.lock();
        try {
            size += val;
            System.out.printf("%s produce(%d) --> size=%d\n",
                    Thread.currentThread().getName(), val, size);
        } finally {
            lock.unlock();
        }
    }

    public void consume(int val) {
        lock.lock();
        try {
            size -= val;
            System.out.printf("%s consume(%d) <-- size=%d\n",
                    Thread.currentThread().getName(), val, size);
        } finally {
            lock.unlock();
        }
    }
};

// 生产者
class Test1Producer {
    private Test1Depot test1Depot;

    public Test1Producer(Test1Depot test1Depot) {
        this.test1Depot = test1Depot;
    }

    // 消费产品：新建一个线程向仓库中生产产品。
    public void produce(final int val) {
        new Thread() {
            public void run() {
                test1Depot.produce(val);
            }
        }.start();
    }
}

// 消费者
class Test1Customer {
    private Test1Depot test1Depot;

    public Test1Customer(Test1Depot test1Depot) {
        this.test1Depot = test1Depot;
    }

    // 消费产品：新建一个线程从仓库中消费产品。
    public void consume(final int val) {
        new Thread() {
            public void run() {
                test1Depot.consume(val);
            }
        }.start();
    }
}

public class LockTest1 {
    public static void main(String[] args) {
        Test1Depot mTest1Depot = new Test1Depot();
        Test1Producer mPro = new Test1Producer(mTest1Depot);
        Test1Customer mCus = new Test1Customer(mTest1Depot);

        mPro.produce(60);
        mPro.produce(120);
        mCus.consume(90);
        mCus.consume(150);
        mPro.produce(110);
    }
}