package hungrythread;

/**
 * description: join()的用法。
 *
 * @author JunchaoYao
 * @date 2020-04-26 20:46
 **/
// JoinTest.java的源码
public class JoinTest{

    public static void main(String[] args){
        try {
            ThreadAjoin t1 = new ThreadAjoin("t1"); // 新建“线程t1”

            t1.start();                     // 启动“线程t1”
            t1.join();                        // 将“线程t1”加入到“主线程main”中，并且“主线程main()会等待它的完成”
            System.out.printf("%s finish\n", Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class ThreadAjoin extends Thread{

        public ThreadAjoin(String name){
            super(name);
        }
        public void run(){
            System.out.printf("%s start\n", this.getName());

            // 延时操作
            for(int i=0; i <1000000; i++)
                ;

            System.out.printf("%s finish\n", this.getName());
        }
    }
}