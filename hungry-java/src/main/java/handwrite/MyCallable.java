package handwrite;

import java.util.concurrent.Callable;

/**
 * description: callable
 *
 * @author JunchaoYao
 * @date 2021-02-04 20:09
 **/
public class MyCallable implements Callable<String> {
    @Override
    public String call(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "call over";

    }

}
