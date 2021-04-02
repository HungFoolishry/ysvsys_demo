package handwrite;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * description: abc
 *
 * @author JunchaoYao
 * @date 2021-03-19 17:12
 **/
public class Main {

    private int max;
    private volatile int ticketsNum=1;
    private final Lock lock = new ReentrantLock();
    private final Condition waitCondition = lock.newCondition();
    Random rand = new Random();

    public Main(int max) {
        this.max = max;
    }

    private void print(String line, int targetNum) {
        for (int i = 0; i < max; ) {
            lock.lock();
            try{
                if (ticketsNum<=max && ((ticketsNum % 2) == targetNum)) {
                    i++;
                    System.out.print(line+ticketsNum+"\n");
                    ticketsNum++;
                    waitCondition.signalAll();
                    try {
                        waitCondition.await(rand.nextInt(200)+100, TimeUnit.MILLISECONDS);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (ticketsNum > max) {
                    break;
                }
            }finally {
                lock.unlock();
            }

        }
    }

    public static void main(String[] args) {
        Main loopThread = new Main(30);

        new Thread(() -> {
            loopThread.print("window 1 sell ticket num ", 1);
        }, "window1").start();

        new Thread(() -> {
            loopThread.print("window 2 sell ticket num ", 0);
        }, "window2").start();

        new Thread(() -> {
            loopThread.print("window 3 sell ticket num ", 1);
        }, "window3").start();
        new Thread(() -> {
            loopThread.print("window 4 sell ticket num ", 1);
        }, "window4").start();
    }
}
