package handwrite;

import java.util.concurrent.SynchronousQueue;

/**
 * description: 交替打印 同步队列
 *
 * @author JunchaoYao
 * @date 2021-02-24 15:43
 **/
public class AlternatePrin4 {
   public void alternatePrintV4() throws InterruptedException {
        final char[] nums = "1234567".toCharArray();
        final char[] alphabets = "ABCDEFG".toCharArray();
        SynchronousQueue<Character> numQueue = new SynchronousQueue<>();
        SynchronousQueue<Character> alphabetQueue = new SynchronousQueue<>();

        //打印字母
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < nums.length; i++) {
                    try {
                        System.out.println(alphabetQueue.take());
                        numQueue.put(nums[i]);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        });

        //打印数字
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < alphabets.length; i++) {
                    try {
                        alphabetQueue.put(alphabets[i]);
                        System.out.println(numQueue.take());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        t1.start();
        t2.start();

        Thread.sleep(10000);
    }

}
