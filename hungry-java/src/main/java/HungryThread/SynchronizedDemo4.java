package HungryThread;

/**
 * description: synchronized代码块可以更精确的控制冲突限制访问区域，有时候表现更高效率
 *
 * @author JunchaoYao
 * @date 2020-04-21 15:35
 **/
// Demo4.java的源码
public class SynchronizedDemo4 {

    public synchronized void synMethod() {
        for(int i=0; i<1000000; i++)
            ;
    }

    public void synBlock() {
        synchronized( this ) {
            for(int i=0; i<1000000; i++)
                ;
        }
    }

    public static void main(String[] args) {
        SynchronizedDemo4 demo = new SynchronizedDemo4();

        long start, diff;
        start = System.currentTimeMillis();                // 获取当前时间(millis)
        demo.synMethod();                                // 调用“synchronized方法”
        diff = System.currentTimeMillis() - start;        // 获取“时间差值”
        System.out.println("synMethod() : "+ diff);

        start = System.currentTimeMillis();                // 获取当前时间(millis)
        demo.synBlock();                                // 调用“synchronized方法块”
        diff = System.currentTimeMillis() - start;        // 获取“时间差值”
        System.out.println("synBlock()  : "+ diff);
    }
}