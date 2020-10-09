package hungrythread;

/**
 * description: 实例锁与类锁
 *
 * @author JunchaoYao
 * @date 2020-04-21 15:38
 **/
// LockTest1.java的源码
class SomethingTest1 {
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
}

public class InsAndClsLockTest1 {

    SomethingTest1 x = new SomethingTest1();
    SomethingTest1 y = new SomethingTest1();

    // 比较(01) x.isSyncA()与x.isSyncB()
    private void test1() {
        // 新建t11, t11会调用 x.isSyncA()
        Thread t11 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        x.isSyncA();
                    }
                }, "t11");

        // 新建t12, t12会调用 x.isSyncB()
        Thread t12 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        x.isSyncB();
                    }
                }, "t12");


        t11.start();  // 启动t11
        t12.start();  // 启动t12
    }

    public static void main(String[] args) {
        InsAndClsLockTest1 demo = new InsAndClsLockTest1();
        demo.test1();
    }
}