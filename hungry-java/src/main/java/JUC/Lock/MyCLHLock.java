package JUC.Lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * description:
 *
 * @author JunchaoYao
 * @date 2020-08-03 16:42
 **/
public class MyCLHLock implements Lock {
    AtomicReference<QueueNode> tail = new AtomicReference<>(new QueueNode());
    ThreadLocal<QueueNode> pre;
    ThreadLocal<QueueNode> current;
    public MyCLHLock() {
        current = ThreadLocal.withInitial(QueueNode::new);
        pre = ThreadLocal.withInitial(() -> null);
    }

    @Override
    public void lock() {
        QueueNode c = current.get();
        c.locked = true;
        QueueNode pre = tail.getAndSet(c);
        this.pre.set(pre);
        if (pre.locked) {
            System.out.println("前节点等待，本节点进行自旋");
        }
    }

    @Override
    public void unlock() {
        QueueNode c = current.get();
        c.locked = false;


    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }



    @Override
    public Condition newCondition() {
        return null;
    }
    static class QueueNode{
        boolean locked;
    }
}
