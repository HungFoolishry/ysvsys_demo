package hungrythread;

/**
 * description: 示例演示notifyAll()的用法；它的作用是唤醒在此对象监视器上等待的所有线程
 *
 * @author JunchaoYao
 * @date 2020-04-21 17:26
 **/
public class NotifyAllTest {

    private static Object obj = new Object();
    public static void main(String[] args) {

        ThreadA3 t1 = new ThreadA3("t1");
        ThreadA3 t2 = new ThreadA3("t2");
        ThreadA3 t3 = new ThreadA3("t3");
        t1.start();
        t2.start();
        t3.start();

        try {
            System.out.println(Thread.currentThread().getName()+" sleep(3000)");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized(obj) {
            // 主线程等待唤醒。
            System.out.println(Thread.currentThread().getName()+" notifyAll()");
            obj.notifyAll();
        }
    }

    static class ThreadA3 extends Thread{

        public ThreadA3(String name){
            super(name);
        }

        public void run() {
            synchronized (obj) {
                try {
                    // 打印输出结果
                    System.out.println(Thread.currentThread().getName() + " wait");

                    // 唤醒当前的wait线程
                    obj.wait();

                    // 打印输出结果
                    System.out.println(Thread.currentThread().getName() + " continue");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}