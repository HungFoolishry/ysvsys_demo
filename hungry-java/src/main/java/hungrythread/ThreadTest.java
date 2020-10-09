package hungrythread;

/**
 * description: 用Thread新建线程
 *
 * @author JunchaoYao
 * @date 2020-04-21 14:57
 **/
// ThreadTest.java 源码
class MyThread2 extends Thread{
    private int ticket=10;
    public void run(){
        for(int i=0;i<20;i++){
            if(this.ticket>0){
                System.out.println(this.getName()+" 卖票：ticket"+this.ticket--);
            }
        }
    }
};

public class ThreadTest {
    public static void main(String[] args) {
        // 启动3个线程t1,t2,t3；每个线程各卖10张票！
        MyThread2 t1=new MyThread2();
        MyThread2 t2=new MyThread2();
        MyThread2 t3=new MyThread2();
        t1.start();
        t2.start();
        t3.start();
    }
}