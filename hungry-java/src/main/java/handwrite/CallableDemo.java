package handwrite;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * description:
 *
 * @author JunchaoYao
 * @date 2021-02-04 20:11
 **/
public class CallableDemo {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 20, 1000, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(10), new ThreadPoolExecutor.AbortPolicy());
        List<Future> results = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            Future future = threadPoolExecutor.submit(new MyCallable());
            results.add(future);
        }
        results.forEach(s->{
            try {
                System.out.println(new Date() + "::" + s.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
        //关闭线程池
        threadPoolExecutor.shutdown();
    }

}
