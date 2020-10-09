package juc.lock;

/**
 * description:
 *
 * @author JunchaoYao
 * @date 2020-07-14 15:13
 **/
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// LockTest2.java
// 仓库
class Test2Depot {
    private int size;        // 仓库的实际数量
    private Lock lock;        // 独占锁

    public Test2Depot() {
        this.size = 0;
        this.lock = new ReentrantLock();
    }

    public void produce(int val) {
//        lock.lock();
//        try {
        size += val;
        System.out.printf("%s produce(%d) --> size=%d\n",
                Thread.currentThread().getName(), val, size);
//        } catch (InterruptedException e) {
//        } finally {
//            lock.unlock();
//        }
    }

    public void consume(int val) {
//        lock.lock();
//        try {
        size -= val;
        System.out.printf("%s consume(%d) <-- size=%d\n",
                Thread.currentThread().getName(), val, size);
//        } finally {
//            lock.unlock();
//        }
    }
};

// 生产者
class Test2Producer {
    private Test2Depot test2Depot;

    public Test2Producer(Test2Depot test2Depot) {
        this.test2Depot = test2Depot;
    }

    // 消费产品：新建一个线程向仓库中生产产品。
    public void produce(final int val) {
        new Thread() {
            public void run() {
                test2Depot.produce(val);
            }
        }.start();
    }
}

// 消费者
class Test2Customer {
    private Test2Depot test2Depot;

    public Test2Customer(Test2Depot test2Depot) {
        this.test2Depot = test2Depot;
    }

    // 消费产品：新建一个线程从仓库中消费产品。
    public void consume(final int val) {
        new Thread() {
            public void run() {
                test2Depot.consume(val);
            }
        }.start();
    }
}

public class LockTest2 {
    public static void main(String[] args) {
        Test2Depot mTest2Depot = new Test2Depot();
        Test2Producer mPro = new Test2Producer(mTest2Depot);
        Test2Customer mCus = new Test2Customer(mTest2Depot);

        mPro.produce(60);
        mPro.produce(120);
        mCus.consume(90);
        mCus.consume(150);
        mPro.produce(110);
    }
}
