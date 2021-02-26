package handwrite;

/**
 * description: 交替打印 synchronized
 *
 * @author JunchaoYao
 * @date 2021-02-24 15:39
 **/


public class AlternatePrint2 {

    static Thread t1 = null, t2 = null;

    /**
     * 使用 synchronized
     */
   public void alternatePrint() {
        Object lock = new Object();
        char[] aI = "1234567".toCharArray();
        char[] aC = "ABCDEFG".toCharArray();

        t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < aC.length; i++) {
                    synchronized (lock) {
                        System.out.println(aC[i]);
                        lock.notify();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < aI.length; i++) {
                    synchronized (lock) {
                        System.out.println(aI[i]);
                        lock.notify();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        t1.start();
        t2.start();
    }
}
