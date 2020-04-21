package HungryThread;

/**
 * description: start 与run demo1
 *
 * @author JunchaoYao
 * @date 2020-04-21 15:20
 **/
// Demo.java 的源码
class MyThread3 extends Thread{
    public MyThread3(String name) {
        super(name);
    }

    public void run(){
        System.out.println(Thread.currentThread().getName()+" is running");
    }
};

public class StartAndRunDemo1 {
    public static void main(String[] args) {
        Thread mythread=new MyThread3("mythread");

        System.out.println(Thread.currentThread().getName()+" call mythread.run()");
        mythread.run();

        System.out.println(Thread.currentThread().getName()+" call mythread.start()");
        mythread.start();
    }
}