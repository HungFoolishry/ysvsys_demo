package HungryThread;

/**
 * description: 1和t2是两个不同的MyThread对象，因此t1和t2在执行synchronized(this)时，获取的是不同对象的同步锁
 *
 * @author JunchaoYao
 * @date 2020-04-21 15:30
 **/
class MyThreadDemo1_2 extends Thread {

    public MyThreadDemo1_2(String name) {
        super(name);
    }

    @Override
    public void run() {
        synchronized(this) {
            try {
                for (int i = 0; i < 5; i++) {
                    Thread.sleep(100); // 休眠100ms
                    System.out.println(Thread.currentThread().getName() + " loop " + i);
                }
            } catch (InterruptedException ie) {
            }
        }
    }
}

public class SynchronizedDemo1_2 {

    public static void main(String[] args) {
        Thread t1 = new MyThreadDemo1_2("t1");  // 新建“线程t1”
        Thread t2 = new MyThreadDemo1_2("t2");  // 新建“线程t2”
        t1.start();                          // 启动“线程t1”
        t2.start();                          // 启动“线程t2”
    }
}