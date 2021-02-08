package handwrite;

/**
 * description: 我的runnable
 *
 * @author JunchaoYao
 * @date 2021-02-04 19:36
 **/
public class MyRunnable implements Runnable{
    private String commend;
    public MyRunnable(String s){
        commend = s;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " hi");
        try {
            process();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("sleep over");

    }

    private void process() throws InterruptedException {
        Thread.sleep(5000);
    }
}
