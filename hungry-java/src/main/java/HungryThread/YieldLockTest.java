package HungryThread;

/**
 * description: wait()是会线程释放它所持有对象的同步锁，而yield()方法不会释放锁
 *
 * @author JunchaoYao
 * @date 2020-04-21 22:02
 **/
// YieldLockTest.java 的源码
public class YieldLockTest{

    private static Object obj = new Object();

    public static void main(String[] args){
        ThreadA4 t1 = new ThreadA4("t1");
        ThreadA4 t2 = new ThreadA4("t2");
        t1.start();
        t2.start();
    }

    static class ThreadA4 extends Thread{
        public ThreadA4(String name){
            super(name);
        }
        public void run(){
            // 获取obj对象的同步锁
            synchronized (obj) {
                for(int i=0; i <10; i++){
                    System.out.printf("%s [%d]:%d\n", this.getName(), this.getPriority(), i);
                    // i整除4时，调用yield
                    if (i%4 == 0)
                        Thread.yield();
                }
            }
        }
    }
}
