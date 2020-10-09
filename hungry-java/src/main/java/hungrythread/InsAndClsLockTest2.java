package hungrythread;

/**
 * description:  可以同时被访问。因为访问的不是同一个对象的同步锁，x.isSyncA()访问的是x的同步锁，而y.isSyncA()访问的是y的同步锁
 *
 * @author JunchaoYao
 * @date 2020-04-21 15:59
 **/
// LockTest2.java的源码
class SomethingTest2 {
    public synchronized void isSyncA(){
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(100); // 休眠100ms
                System.out.println(Thread.currentThread().getName()+" : isSyncA");
            }
        }catch (InterruptedException ie) {
        }
    }
    public synchronized void isSyncB(){
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(100); // 休眠100ms
                System.out.println(Thread.currentThread().getName()+" : isSyncB");
            }
        }catch (InterruptedException ie) {
        }
    }
    public static synchronized void cSyncA(){
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(100); // 休眠100ms
                System.out.println(Thread.currentThread().getName()+" : cSyncA");
            }
        }catch (InterruptedException ie) {
        }
    }
    public static synchronized void cSyncB(){
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(100); // 休眠100ms
                System.out.println(Thread.currentThread().getName()+" : cSyncB");
            }
        }catch (InterruptedException ie) {
        }
    }
}

public class InsAndClsLockTest2 {

    SomethingTest2 x = new SomethingTest2();
    SomethingTest2 y = new SomethingTest2();

    // 比较(02) x.isSyncA()与y.isSyncA()
    private void test2() {
        // 新建t21, t21会调用 x.isSyncA()
        Thread t21 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        x.isSyncA();
                    }
                }, "t21");

        // 新建t22, t22会调用 x.isSyncB()
        Thread t22 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        y.isSyncA();
                    }
                }, "t22");


        t21.start();  // 启动t21
        t22.start();  // 启动t22
    }

    public static void main(String[] args) {
        InsAndClsLockTest2 demo = new InsAndClsLockTest2();

        demo.test2();
    }
}
