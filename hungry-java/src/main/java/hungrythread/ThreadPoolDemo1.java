package hungrythread;

/**
 * description:
 *
 * @author JunchaoYao
 * @date 2020-09-28 19:30
 **/
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class ThreadPoolDemo1 {

    public static void main(String[] args) {
        // 创建一个可重用固定线程数的线程池
        ExecutorService pool = Executors.newFixedThreadPool(2);
        // 创建实现了Runnable接口对象，Thread对象当然也实现了Runnable接口
        Thread ta = new MyThreadDemo1();
        Thread tb = new MyThreadDemo1();
        Thread tc = new MyThreadDemo1();
        Thread td = new MyThreadDemo1();
        Thread te = new MyThreadDemo1();
        // 将线程放入池中进行执行
        pool.execute(ta);
        pool.execute(tb);
        pool.execute(tc);
        pool.execute(td);
        pool.execute(te);
        // 关闭线程池
        pool.shutdown();
    }
}

class MyThreadDemo1 extends Thread {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+ " is running.");
    }
}